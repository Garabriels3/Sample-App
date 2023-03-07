package com.br.data.request

import com.squareup.moshi.Json

data class OriginalUrlRequest(
    @Json(name = "url")
    val url: String
)