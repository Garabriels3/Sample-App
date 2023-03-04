package com.br.data.response

import com.squareup.moshi.Json

data class ShortenedUrlResponse(
    @Json(name = "alias")
    val alias: String,

    @Json(name = "_links")
    val linksResponse: LinksResponse
)
