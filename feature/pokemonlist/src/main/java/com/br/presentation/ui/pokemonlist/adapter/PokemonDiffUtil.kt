package com.br.presentation.ui.pokemonlist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.br.presentation.model.PokemonUi

class PokemonDiffUtil : DiffUtil.ItemCallback<PokemonUi>() {

    override fun areItemsTheSame(
        oldItem: PokemonUi,
        newItem: PokemonUi
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: PokemonUi,
        newItem: PokemonUi
    ): Boolean {
        return oldItem.name == newItem.name
    }
}