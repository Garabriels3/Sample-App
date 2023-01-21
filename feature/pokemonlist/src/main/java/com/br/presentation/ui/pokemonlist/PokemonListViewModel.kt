package com.br.presentation.ui.pokemonlist

import androidx.lifecycle.viewModelScope
import com.br.commonui.baseviewmodel.BaseViewModel
import com.br.domain.model.PokemonResultModel
import com.br.domain.usecase.pokemonlist.PokemonListUseCase
import com.br.presentation.model.PokemonUi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val useCase: PokemonListUseCase
) : BaseViewModel<PokemonListState, PokemonListAction>(PokemonListState(isLoading = true)) {

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            useCase.getPokemonList()
                .map { pokemonList ->
                    pokemonList.mapToPresentation()
                }
                .catch { error ->
                    setState {
                        it.setErrorState(error)
                    }
                }
                .collect { result ->
                    setState {
                        it.setSuccessState(result)
                    }
                }
        }
    }

    private fun PokemonResultModel.mapToPresentation() =
        pokemonList.map {
            PokemonUi(
                name = it.name,
                url = it.url
            )
        }

}