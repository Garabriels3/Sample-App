package com.br.di

import com.br.domain.usecase.linkshortener.LinkShortenerUseCase
import com.br.domain.usecase.linkshortener.LinkShortenerUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<LinkShortenerUseCase> { LinkShortenerUseCaseImpl(get()) }
}