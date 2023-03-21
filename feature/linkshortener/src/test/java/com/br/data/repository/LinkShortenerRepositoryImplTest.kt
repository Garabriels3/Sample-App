package com.br.data.repository

import app.cash.turbine.test
import com.br.data.datasource.remote.linkshortener.LinkShortenerRemoteDataSourceImpl
import com.br.data.mapper.ShortenedUrlResponseToShortenedUrlModelMapper
import com.br.data.response.LinksResponse
import com.br.data.response.ShortenedUrlResponse
import com.br.data.service.LinkShortenerService
import com.br.domain.model.LinksModel
import com.br.domain.model.ShortenedUrlModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class LinkShortenerRepositoryImplTest {

    private val linkShortenerService = mockk<LinkShortenerService>()
    private val shortenedUrlModelMapper = ShortenedUrlResponseToShortenedUrlModelMapper()
    private val linkShortenerRemoteDataSource = LinkShortenerRemoteDataSourceImpl(
        linkShortenerService = linkShortenerService,
    )

    private val repository = LinkShortenerRepositoryImpl(
        shortenedUrlModelMapper = shortenedUrlModelMapper,
        linkShortenerRemoteDataSource = linkShortenerRemoteDataSource
    )

    @Test
    fun createShortUrl_withSuccess_shouldReturnShortenedUrlModel() = runBlocking {
        // Given
        prepareScenario()
        val expected = ShortenedUrlModel(
            alias = "google",
            links = LinksModel(
                self = "https://www.google.com.br/",
                short = "shorturl.at/eozPZ"
            )
        )

        // When
        val response = repository.createShortUrl("https://www.google.com.br/")

        // Then
        response.test {
            assertEquals(expected, expectItem())
            expectComplete()
        }
    }

    @Test
    fun createShortUrl_withError_shouldReturnError() = runBlocking {
        // Given
        prepareErrorScenario()

        // When
        val response = repository.createShortUrl("https://www.google.com.br/")

        // Then
        response.test {
            expectError()
        }
    }

    private fun prepareScenario() {
        coEvery { linkShortenerService.createShortenedUrl(any()) } returns ShortenedUrlResponse(
            alias = "google",
            linksResponse = LinksResponse(
                self = "https://www.google.com.br/",
                short = "shorturl.at/eozPZ"
            )
        )
    }

    private fun prepareErrorScenario() {
        coEvery { linkShortenerService.createShortenedUrl(any()) } throws
                Exception("Ocorreu um erro ao encurtar a url")
    }
}