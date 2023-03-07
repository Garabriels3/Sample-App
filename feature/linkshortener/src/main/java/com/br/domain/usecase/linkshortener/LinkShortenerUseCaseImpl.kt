package com.br.domain.usecase.linkshortener

import com.br.domain.model.LinksModel
import com.br.domain.model.ShortenedUrlModel
import com.br.domain.repository.LinkShortenerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

class LinkShortenerUseCaseImpl(
    private val linkShortenerRepository: LinkShortenerRepository
) : LinkShortenerUseCase {
    override fun createShortUrl(originalUrl: String): Flow<ShortenedUrlModel> {
//        return flow {
//            kotlinx.coroutines.delay(2000)
//            emit(shortenedUrlModelFactory())
//        }.flowOn(Dispatchers.IO)
        return linkShortenerRepository.createShortUrl(originalUrl)
    }

    private fun shortenedUrlModelFactory() =
        ShortenedUrlModel(
            alias = Random().nextInt().toString(),
            links = linksModelFactory()
        )

    private fun linksModelFactory() =
        LinksModel(
            self = Random().nextInt().toString(),
            short = Random().nextInt().toString()
        )
}