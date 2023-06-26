package com.br.presentation.shortlinklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.br.linkshortener.databinding.FragmentShortLinkListBinding
import com.br.presentation.baseview.BaseFragment
import com.br.presentation.shortlinklist.adapter.ShortLinkAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShortLinkListFragment : BaseFragment<ShortLinkListState, ShortLinkListAction>() {

    private val binding by lazy { FragmentShortLinkListBinding.inflate(layoutInflater) }
    override val viewModel by viewModel<ShortLinkListViewModel>()
    private val adapter by lazy { ShortLinkAdapter() }

    override fun onViewSetup(view: View, savedInstanceState: Bundle?) {
        setupAdapter()
        onSendOriginalUrl()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onActionListener(action: ShortLinkListAction) {
        TODO("Not yet implemented")
    }

    override fun onStateListener(state: ShortLinkListState) {
        with(state) {
            onSuccessState()
            onErrorState()
            onLoadingState()
        }
    }

    private fun ShortLinkListState.onSuccessState() {
        if (shortLinks.isNotEmpty()) {
            adapter.submitList(shortLinks)
            adapter.notifyItemChanged(shortLinks.lastIndex)
            binding.rvShortLinkList.visibility = View.VISIBLE
            binding.pbLoading.visibility = View.GONE
            binding.incEmptyState.root.visibility = View.GONE
            binding.incErrorState.root.visibility = View.GONE
        } else {
            onEmptyState()
        }
    }

    private fun ShortLinkListState.onErrorState() {
        if (error != null) {
            binding.incErrorState.root.visibility = View.VISIBLE
            binding.pbLoading.visibility = View.GONE
            binding.rvShortLinkList.visibility = View.GONE
            binding.incEmptyState.root.visibility = View.GONE
        }
    }

    private fun ShortLinkListState.onLoadingState() {
        if (isLoading) {
            binding.pbLoading.visibility = View.VISIBLE
            binding.incEmptyState.root.visibility = View.GONE
            binding.incErrorState.root.visibility = View.GONE
            binding.rvShortLinkList.visibility = View.GONE
        }
    }

    private fun onEmptyState() {
        binding.incEmptyState.root.visibility = View.VISIBLE
        binding.pbLoading.visibility = View.GONE
        binding.rvShortLinkList.visibility = View.GONE
        binding.incErrorState.root.visibility = View.GONE
    }

    private fun onSendOriginalUrl() {
        binding.btnShortLink.setOnClickListener {
            viewModel.onShortUrl(binding.etOriginalLink.text.toString())
        }
    }

    private fun setupAdapter() {
        binding.rvShortLinkList.adapter = adapter
    }
}