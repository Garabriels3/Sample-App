package com.br.data.di

import com.br.commondata.apiconfig.apiclient.HttpClient.makeService
import com.br.data.api.PokemonService
import com.br.data.datasource.remote.pokemonlist.PokemonListRemoteDataSource
import com.br.data.datasource.remote.pokemonlist.PokemonListRemoteDataSourceImpl
import com.br.data.mapper.PokemonResultResponseToPokemonResultModelMapperImpl
import com.br.data.repository.PokemonListRepositoryImpl
import com.br.domain.repository.PokemonListRepository
import org.koin.dsl.module

val service = module {
    single { makeService<PokemonService>() }
}

val dataModule = module {
    factory<PokemonListRemoteDataSource>{ PokemonListRemoteDataSourceImpl(get()) }
    factory<PokemonListRepository>{ PokemonListRepositoryImpl(get(), PokemonResultResponseToPokemonResultModelMapperImpl()) }
}