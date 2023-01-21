package com.br.presentation.ui.pokemonlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.br.presentation.model.PokemonUi
import com.br.presentation.ui.pokemonlist.databinding.PokemonItemBinding

class PokemonListAdapter : ListAdapter<PokemonUi, PokemonViewHolder>(PokemonDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
       return PokemonViewHolder(
           PokemonItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
              )
       )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}