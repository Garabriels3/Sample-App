package com.br.data.response

import com.squareup.moshi.Json
data class LinksResponse(
    @Json(name = "self")
    val self: String,

    @Json(name = "short")
    val short: String
)
