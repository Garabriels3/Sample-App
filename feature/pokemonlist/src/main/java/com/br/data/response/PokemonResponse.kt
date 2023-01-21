package com.br.data.response

import com.squareup.moshi.Json

data class PokemonResponse(
    @Json(name = "name")
    val name: String,

    @Json(name = "url")
    val url: String
)