package com.br.domain.usecase.linkshortener

import com.br.domain.model.ShortenedUrlModel
import kotlinx.coroutines.flow.Flow

interface LinkShortenerUseCase {
    fun createShortUrl(originalUrl: String): Flow<ShortenedUrlModel>
}