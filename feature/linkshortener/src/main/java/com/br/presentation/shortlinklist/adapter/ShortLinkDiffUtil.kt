package com.br.presentation.shortlinklist.adapter

import androidx.recyclerview.widget.DiffUtil
import com.br.presentation.uimodel.ShortenedUrlUI

class ShortLinkDiffUtil : DiffUtil.ItemCallback<ShortenedUrlUI>() {
    override fun areItemsTheSame(oldItem: ShortenedUrlUI, newItem:ShortenedUrlUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ShortenedUrlUI, newItem: ShortenedUrlUI): Boolean {
        return oldItem.links.short == newItem.links.short
    }
}