package com.br.data.mapper

import com.br.common.interfaces.Mapper
import com.br.data.response.PokemonResultResponse
import com.br.domain.model.PokemonModel
import com.br.domain.model.PokemonResultModel

class PokemonResultResponseToPokemonResultModelMapperImpl : Mapper<PokemonResultResponse, PokemonResultModel> {
    override fun map(source: PokemonResultResponse): PokemonResultModel {
        return PokemonResultModel(
            pokemonList = source.pokemonList.map { pokemonResponse ->
                PokemonModel(
                    name = pokemonResponse.name,
                    url = pokemonResponse.url
                )
            }
        )
    }
}