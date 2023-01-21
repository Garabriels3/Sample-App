package com.br.data.repository

import com.br.common.interfaces.Mapper
import com.br.data.datasource.remote.pokemonlist.PokemonListRemoteDataSource
import com.br.data.response.PokemonResultResponse
import com.br.domain.model.PokemonResultModel
import com.br.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PokemonListRepositoryImpl(
    private val pokemonListRemoteDataSource: PokemonListRemoteDataSource,
    private val pokemonResultResponseToPokemonResultModelMapper: Mapper<PokemonResultResponse, PokemonResultModel>
) : PokemonListRepository {
    override fun getPokemonList(): Flow<PokemonResultModel> {
        return pokemonListRemoteDataSource.getPokemonList().map {
            pokemonResultResponseToPokemonResultModelMapper.map(it)
        }
    }
}