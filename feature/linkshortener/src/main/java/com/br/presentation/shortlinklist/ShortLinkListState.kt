package com.br.presentation.shortlinklist

import com.br.presentation.baseviewmodel.UIState
import com.br.presentation.uimodel.ShortenedUrlUI

data class ShortLinkListState(
    val isLoading: Boolean = false,
    val shortLinks: List<ShortenedUrlUI> = listOf(),
    val error: String? = null,
) : UIState {
    fun setLoadingState() = copy(isLoading = true, error = null)
    fun setSuccessState(shortLinks: List<ShortenedUrlUI>) = copy(
        isLoading = false,
        shortLinks = shortLinks,
        error = null
    )
    fun setErrorState(error: String) = copy(isLoading = false, error = error)
}