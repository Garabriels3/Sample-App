package com.br.presentation.shortlinklist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.br.linkshortener.databinding.ShortLinkItemBinding
import com.br.presentation.uimodel.ShortenedUrlUI

class ShortLinkViewHolder(private val binding: ShortLinkItemBinding) : ViewHolder(binding.root) {

    fun bind(shortLink: ShortenedUrlUI) {
        with(binding) {
            tvAlias.text = shortLink.alias
            tvOriginalLink.text = shortLink.links.self
            tvShortLink.text = shortLink.links.short
        }
    }
}