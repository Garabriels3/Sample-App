package com.br.presentation.shortlinklist

import androidx.lifecycle.viewModelScope
import com.br.domain.model.ShortenedUrlModel
import com.br.domain.usecase.linkshortener.LinkShortenerUseCase
import com.br.general.mapper.Mapper
import com.br.presentation.baseviewmodel.BaseViewModel
import com.br.presentation.uimodel.ShortenedUrlUI
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

private const val DEFAULT_ERROR_MESSAGE = "Algo deu errado"

class ShortLinkListViewModel(
    private val linkShortenerUseCase: LinkShortenerUseCase,
    private val shortLinkModelToShortenedUrlUIMapper: Mapper<ShortenedUrlModel, ShortenedUrlUI>
) : BaseViewModel<ShortLinkListState, ShortLinkListAction>(
    initialState = ShortLinkListState(isLoading = false)
) {
    private val shortLinkList = mutableListOf<ShortenedUrlUI>()

    fun onShortUrl(originalUrl: String) {
        viewModelScope.launch {
            linkShortenerUseCase.createShortUrl(originalUrl)
                .catch { error ->
                    setState {
                        it.setErrorState(error.message ?: DEFAULT_ERROR_MESSAGE)
                    }
                }
                .map { result ->
                    shortLinkModelToShortenedUrlUIMapper.map(result).also {
                        shortLinkList.add(it)
                    }
                    shortLinkList
                }
                .onStart { setState { it.setLoadingState() } }
                .collect {
                    setState { state ->
                        state.setSuccessState(it)
                    }
                }
        }
    }
}