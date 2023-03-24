package com.br.di

import com.br.presentation.mapper.ShortenedUrlModelToShortenedUrlUIMapper
import com.br.presentation.shortlinklist.ShortLinkListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ShortLinkListViewModel(get(), ShortenedUrlModelToShortenedUrlUIMapper()) }
}