package com.br.presentation.di

import com.br.presentation.ui.pokemonlist.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    viewModel { PokemonListViewModel(get()) }
}