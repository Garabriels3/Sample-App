package com.br.data.response

import com.squareup.moshi.Json

data class PokemonResultResponse(
    @Json(name = "results")
    val pokemonList: List<PokemonResponse>
)