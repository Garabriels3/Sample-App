package com.br.presentation.ui.pokemonlist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.br.presentation.model.PokemonUi
import com.br.presentation.ui.pokemonlist.databinding.PokemonItemBinding

class PokemonViewHolder(private val binding: PokemonItemBinding) : ViewHolder(binding.root) {

    fun bind(pokemonUi: PokemonUi) {
        binding.tvPokemonName.text = pokemonUi.name
    }
}