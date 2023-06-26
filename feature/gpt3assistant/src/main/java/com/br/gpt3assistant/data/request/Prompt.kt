package com.br.gpt3assistant.data.request

import com.squareup.moshi.Json

data class GptRequest(
    @Json(name = "prompt") val prompt: String,
    @Json(name = "max_tokens") val maxTokens: Int = 1100,
    @Json(name = "temperature") val temperature: Double = 0.5,
)
