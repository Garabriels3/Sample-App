package com.br.gpt3assistant.data.datasource.remote

import com.br.gpt3assistant.data.reponse.GptResponse
import com.br.gpt3assistant.data.request.GptRequest
import kotlinx.coroutines.flow.Flow

interface ChatGptAssistantRemoteDataSource {
    fun getChatGptAssistantResponse(request: GptRequest): Flow<GptResponse>
}