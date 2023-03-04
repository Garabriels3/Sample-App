package com.br.data.datasource.remote.linkshortener

import com.br.data.request.OriginalUrlRequest
import com.br.data.response.ShortenedUrlResponse
import com.br.data.service.LinkShortenerService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LinkShortenerRemoteDataSourceImpl(
    private val linkShortenerService: LinkShortenerService,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : LinkShortenerRemoteDataSource {
    override fun createShortUrl(originalUrl: OriginalUrlRequest): Flow<ShortenedUrlResponse> {
        return flow {
            emit(linkShortenerService.createShortenedUrl(request = originalUrl))
        }.flowOn(ioDispatcher)
    }
}