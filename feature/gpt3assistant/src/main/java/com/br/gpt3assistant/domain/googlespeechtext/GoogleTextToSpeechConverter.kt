package com.br.gpt3assistant.domain.googlespeechtext

import kotlinx.coroutines.flow.Flow

interface GoogleTextToSpeechConverter {
    fun convertTextToSpeech(text: String): Flow<ByteArray>
}