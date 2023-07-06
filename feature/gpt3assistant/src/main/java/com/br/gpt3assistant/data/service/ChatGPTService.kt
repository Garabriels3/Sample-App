package com.br.gpt3assistant.data.service

import com.br.gpt3assistant.data.reponse.GptResponse
import com.br.gpt3assistant.data.request.GptRequest
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val KEY = "TODO/Fazer estratégia de segurança do App"
interface ChatGPTService {
    @Headers("Content-Type: application/json", "Authorization: Bearer $KEY")
    @POST("v1/engines/text-davinci-003/completions")
    suspend fun getCompletion(@Body prompt: GptRequest): GptResponse
}