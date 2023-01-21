package com.br.domain.di

import com.br.domain.usecase.pokemonlist.PokemonListUseCase
import com.br.domain.usecase.pokemonlist.PokemonListUseCaseImpl
import org.koin.dsl.module

val domain = module {
    factory<PokemonListUseCase>{ PokemonListUseCaseImpl(get()) }
}