package com.br.gpt3assistant.domain.converterfacade

import com.br.gpt3assistant.domain.googlespeechtext.GoogleTextToSpeechConverter
import kotlinx.coroutines.flow.Flow

class AudioConverterImpl(
    private val textToSpeechConverter: GoogleTextToSpeechConverter
) : AudioConverterFacade {

    override fun convertTextToAudio(text: String): Flow<ByteArray> {
        return textToSpeechConverter.convertTextToSpeech(text)
    }
}