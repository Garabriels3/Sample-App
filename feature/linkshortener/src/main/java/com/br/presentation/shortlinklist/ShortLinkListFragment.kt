package com.br.presentation.shortlinklist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.linkshortener.databinding.FragmentShortLinkListBinding
import com.br.presentation.baseview.BaseFragment

class ShortLinkListFragment : Fragment() {

    private val binding by lazy { FragmentShortLinkListBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}