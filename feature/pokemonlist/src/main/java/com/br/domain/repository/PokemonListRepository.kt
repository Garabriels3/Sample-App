package com.br.domain.repository

import com.br.domain.model.PokemonResultModel
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    fun getPokemonList() : Flow<PokemonResultModel>
}