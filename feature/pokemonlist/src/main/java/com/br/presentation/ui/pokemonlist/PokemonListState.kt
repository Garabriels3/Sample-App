package com.br.presentation.ui.pokemonlist

import com.br.commonui.baseviewmodel.UIState
import com.br.domain.model.PokemonResultModel
import com.br.presentation.model.PokemonUi

data class PokemonListState(
    val pokemonList: List<PokemonUi> = emptyList(),
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val isEmpty: Boolean = false
) : UIState {
    fun setSuccessState(pokemonList: List<PokemonUi>) = copy(pokemonList = pokemonList, isLoading = false, error = null, isEmpty = false)
    fun setLoadingState() = copy(isLoading = true, error = null, isEmpty = false)
    fun setErrorState(error: Throwable) = copy(isLoading = false, error = error, isEmpty = false)
    fun setEmptyState() = copy(isLoading = false, error = null, isEmpty = true)
}
