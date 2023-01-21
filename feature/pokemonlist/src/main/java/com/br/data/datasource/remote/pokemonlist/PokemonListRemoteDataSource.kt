package com.br.data.datasource.remote.pokemonlist

import com.br.data.response.PokemonResultResponse
import kotlinx.coroutines.flow.Flow

interface PokemonListRemoteDataSource {
    fun getPokemonList() : Flow<PokemonResultResponse>
}