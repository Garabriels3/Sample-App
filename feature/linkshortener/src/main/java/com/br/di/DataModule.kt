package com.br.di

import com.br.data.apiconfig.apiclient.HttpClient.makeService
import com.br.data.datasource.remote.linkshortener.LinkShortenerRemoteDataSource
import com.br.data.datasource.remote.linkshortener.LinkShortenerRemoteDataSourceImpl
import com.br.data.mapper.ShortenedUrlResponseToShortenedUrlModelMapper
import com.br.data.repository.LinkShortenerRepositoryImpl
import com.br.data.service.LinkShortenerService
import com.br.domain.repository.LinkShortenerRepository
import org.koin.dsl.module

val serviceModule = module { makeService<LinkShortenerService>() }

val dataModule = module {
        factory<LinkShortenerRemoteDataSource> { LinkShortenerRemoteDataSourceImpl(get()) }
        factory<LinkShortenerRepository> { LinkShortenerRepositoryImpl(get(), ShortenedUrlResponseToShortenedUrlModelMapper()) }
}
