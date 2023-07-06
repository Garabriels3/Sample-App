package com.br.gpt3assistant.presentation.audioconverter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

class SpeechRecognitionService(context: Context) {

    private val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)

    fun startListening(
        onReadyForListening: () -> Unit = {},
    ): Flow<String> {
        return callbackFlow {
            val resultChannel = Channel<String>()

            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
                putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            }

            val listener = object : RecognitionListener {
                override fun onResults(results: Bundle) {
                    val matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    if (matches != null) {
                        for (result in matches) {
                            resultChannel.trySend(result)
                        }
                    }
                }

                override fun onReadyForSpeech(params: Bundle) {
                    onReadyForListening()
                }

                override fun onBeginningOfSpeech() {}
                override fun onRmsChanged(rmsdB: Float) {}
                override fun onBufferReceived(buffer: ByteArray) {}
                override fun onEndOfSpeech() {}
                override fun onError(error: Int) {
                    resultChannel.trySend("Pode me ajudar?")
                }

                override fun onPartialResults(partialResults: Bundle) {}
                override fun onEvent(eventType: Int, params: Bundle) {}
            }

            speechRecognizer.setRecognitionListener(listener)
            speechRecognizer.startListening(intent)

            launch {
                for (result in resultChannel) {
                    send(result)
                }
            }

            awaitClose {
                speechRecognizer.stopListening()
                speechRecognizer.destroy()
                resultChannel.close()
            }
        }
    }
}