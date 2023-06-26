package com.br.gpt3assistant.domain.converterfacade

import kotlinx.coroutines.flow.Flow

interface AudioConverterFacade {
    fun convertTextToAudio(text: String): Flow<ByteArray>
}