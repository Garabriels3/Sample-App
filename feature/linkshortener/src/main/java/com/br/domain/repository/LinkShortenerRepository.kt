package com.br.domain.repository

import com.br.domain.model.ShortenedUrlModel
import kotlinx.coroutines.flow.Flow

interface LinkShortenerRepository {
    fun createShortUrl(originalUrl: String): Flow<ShortenedUrlModel>
}