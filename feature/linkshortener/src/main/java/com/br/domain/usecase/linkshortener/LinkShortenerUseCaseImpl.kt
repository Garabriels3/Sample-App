package com.br.domain.usecase.linkshortener

import com.br.domain.model.ShortenedUrlModel
import com.br.domain.repository.LinkShortenerRepository
import kotlinx.coroutines.flow.Flow

class LinkShortenerUseCaseImpl(
    private val linkShortenerRepository: LinkShortenerRepository
) : LinkShortenerUseCase {
    override fun createShortUrl(originalUrl: String): Flow<ShortenedUrlModel> {
        return linkShortenerRepository.createShortUrl(originalUrl)
    }
}