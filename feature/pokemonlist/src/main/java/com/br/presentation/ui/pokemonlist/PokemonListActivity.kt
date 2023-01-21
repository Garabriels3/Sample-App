package com.br.presentation.ui.pokemonlist

import android.os.Bundle
import android.view.View
import com.br.commonui.baseview.BaseActivity
import com.br.presentation.ui.pokemonlist.adapter.PokemonListAdapter
import com.br.presentation.ui.pokemonlist.databinding.ActivityPokemonListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListActivity : BaseActivity<PokemonListState, PokemonListAction>() {

    private val viewModel by viewModel<PokemonListViewModel>()

    private val binding by lazy {
        ActivityPokemonListBinding.inflate(layoutInflater)
    }

    private val adapter by lazy {
        PokemonListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onStartActivity(viewModel.state, viewModel.action)
        setAdapter()
    }

    override fun onStateListener(state: PokemonListState) {
        when {
            state.isLoading -> {
                binding.pbLoading.visibility = View.VISIBLE
            }
            state.pokemonList.isNotEmpty() -> {
                binding.pbLoading.visibility = View.GONE
                adapter.submitList(state.pokemonList)
            }
        }
    }

    override fun onActionListener(action: PokemonListAction) {
        TODO("Not yet implemented")
    }

    private fun setAdapter() {
        binding.rvPokemonList.adapter = adapter
    }
}