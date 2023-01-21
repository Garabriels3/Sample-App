package com.br.domain.usecase.pokemonlist

import com.br.domain.model.PokemonResultModel
import kotlinx.coroutines.flow.Flow

interface PokemonListUseCase {
    fun getPokemonList() : Flow<PokemonResultModel>
}