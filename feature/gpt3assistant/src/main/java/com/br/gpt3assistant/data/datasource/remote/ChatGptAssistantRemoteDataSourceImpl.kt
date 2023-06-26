package com.br.gpt3assistant.data.datasource.remote

import com.br.gpt3assistant.data.reponse.GptResponse
import com.br.gpt3assistant.data.request.GptRequest
import com.br.gpt3assistant.data.service.ChatGPTService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ChatGptAssistantRemoteDataSourceImpl(private val chatGptAssistantService: ChatGPTService) :
    ChatGptAssistantRemoteDataSource {
    override fun getChatGptAssistantResponse(request: GptRequest): Flow<GptResponse> {
        return flow {
            emit(chatGptAssistantService.getCompletion(request))
        }.flowOn(Dispatchers.IO)
    }
}