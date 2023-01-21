package com.br.data.datasource.remote.pokemonlist

import com.br.data.api.PokemonListService
import com.br.data.response.PokemonResultResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonListRemoteDataSourceImpl(
    private val pokemonListService: PokemonListService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PokemonListRemoteDataSource {
    override fun getPokemonList(): Flow<PokemonResultResponse> {
       return flow {
            emit(pokemonListService.getPokemonList())
        }.flowOn(dispatcher)
    }
}