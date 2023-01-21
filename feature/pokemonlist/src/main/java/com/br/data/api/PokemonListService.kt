package com.br.data.api

import com.br.data.response.PokemonResultResponse
import retrofit2.http.GET

interface PokemonListService {
    @GET("api/v2/pokemon")
    suspend fun getPokemonList() : PokemonResultResponse
}