package com.br.domain.usecase.pokemonlist

import com.br.domain.model.PokemonResultModel
import com.br.domain.repository.PokemonListRepository
import kotlinx.coroutines.flow.Flow

class PokemonListUseCaseImpl(
    private val PokemonListRepository: PokemonListRepository
) : PokemonListUseCase {
    override fun getPokemonList(): Flow<PokemonResultModel> {
        return PokemonListRepository.getPokemonList()
    }
}