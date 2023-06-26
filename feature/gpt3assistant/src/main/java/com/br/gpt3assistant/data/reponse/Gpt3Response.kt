package com.br.gpt3assistant.data.reponse

import com.squareup.moshi.Json

data class GptResponse(
    @Json(name = "choices") val choices: List<GptChoice>,
    @Json(name = "created") val created: Long,
    @Json(name = "id") val id: String,
    @Json(name = "model") val model: String
)

data class GptChoice(
    @Json(name = "text") val text: String,
)