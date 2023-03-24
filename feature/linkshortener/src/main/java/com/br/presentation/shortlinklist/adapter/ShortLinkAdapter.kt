package com.br.presentation.shortlinklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.br.linkshortener.databinding.ShortLinkItemBinding
import com.br.presentation.uimodel.ShortenedUrlUI

class ShortLinkAdapter : ListAdapter<ShortenedUrlUI, ShortLinkViewHolder>(ShortLinkDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortLinkViewHolder {
        return ShortLinkViewHolder(
            ShortLinkItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ShortLinkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}