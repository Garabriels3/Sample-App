package com.br.data.repository

import com.br.data.datasource.remote.linkshortener.LinkShortenerRemoteDataSource
import com.br.data.request.OriginalUrlRequest
import com.br.data.response.ShortenedUrlResponse
import com.br.domain.model.ShortenedUrlModel
import com.br.domain.repository.LinkShortenerRepository
import com.br.general.mapper.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LinkShortenerRepositoryImpl(
    private val linkShortenerRemoteDataSource: LinkShortenerRemoteDataSource,
    private val shortenedUrlModelMapper: Mapper<ShortenedUrlResponse, ShortenedUrlModel>
) : LinkShortenerRepository {
    override fun createShortUrl(originalUrl: String): Flow<ShortenedUrlModel> {
        return linkShortenerRemoteDataSource.createShortUrl(OriginalUrlRequest(originalUrl)).map {
            shortenedUrlModelMapper.map(it)
        }
    }
}