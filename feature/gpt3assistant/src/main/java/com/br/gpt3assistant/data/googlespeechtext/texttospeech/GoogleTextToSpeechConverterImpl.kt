package com.br.gpt3assistant.data.googlespeechtext.texttospeech

import android.content.Context
import com.br.gpt3assistant.R
import com.br.gpt3assistant.domain.googlespeechtext.GoogleTextToSpeechConverter
import com.google.api.gax.core.FixedCredentialsProvider
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.texttospeech.v1.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.InputStream

class GoogleTextToSpeechConverterImpl(
    private val context: Context
) : GoogleTextToSpeechConverter {
    private val credentials: GoogleCredentials by lazy {
        val credentialsStream: InputStream = context.resources.openRawResource(R.raw.credential)
        GoogleCredentials.fromStream(credentialsStream)
    }

    private val textToSpeechClient: TextToSpeechClient by lazy {
        TextToSpeechClient.create(
            TextToSpeechClient.create().settings.toBuilder()
                .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
                .build()
        )
    }

    override fun convertTextToSpeech(text: String): Flow<ByteArray> = flow {
        val input = SynthesisInput.newBuilder()
            .setText(text)
            .build()
        val voice = VoiceSelectionParams.newBuilder()
            .setLanguageCode("pt-BR")
            .setSsmlGender(SsmlVoiceGender.NEUTRAL)
            .build()
        val audioConfig = AudioConfig.newBuilder()
            .setAudioEncoding(AudioEncoding.LINEAR16)
            .build()
        try {
            val response = textToSpeechClient.synthesizeSpeech(input, voice, audioConfig)
            emit(response.audioContent.toByteArray())
        } catch (e: Exception) {
            emit(byteArrayOf())
        }
    }
}