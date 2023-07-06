package com.br.data.datasource.remote.linkshortener

import com.br.data.request.OriginalUrlRequest
import com.br.data.response.ShortenedUrlResponse
import kotlinx.coroutines.flow.Flow

interface LinkShortenerRemoteDataSource {
    fun createShortUrl(originalUrl: OriginalUrlRequest): Flow<ShortenedUrlResponse>
}