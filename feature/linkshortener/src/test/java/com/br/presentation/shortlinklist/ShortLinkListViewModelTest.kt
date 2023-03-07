package com.br.presentation.shortlinklist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.br.domain.model.ShortenedUrlModel
import com.br.domain.usecase.linkshortener.LinkShortenerUseCase
import com.br.general.mapper.Mapper
import com.br.presentation.uimodel.ShortenedUrlUI
import com.br.stubs.makeShortenedUrlModel
import com.br.stubs.makeShortenedUrlUi
import com.br.testrules.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ShortLinkListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private var stateObserver: Observer<ShortLinkListState> = mockk()

    private val originalUrl = "https://www.google.com"


    private val linkShortenerUseCase = mockk<LinkShortenerUseCase>()
    private val shortLinkModelToShortenedUrlUIMapper =
        mockk<Mapper<ShortenedUrlModel, ShortenedUrlUI>>()

    private val shortLinkListViewModel = ShortLinkListViewModel(
        linkShortenerUseCase = linkShortenerUseCase,
        shortLinkModelToShortenedUrlUIMapper = shortLinkModelToShortenedUrlUIMapper
    )

    @Test
    fun onShortUrl_withValidOriginalUrl_ShouldReturnASuccessState() = runBlocking {
        // Arrange
        val shortenedUrlModel = makeShortenedUrlModel()
        val shortenedUrlUI = makeShortenedUrlUi()
        prepareScenario(
            shortenedUrlModel = shortenedUrlModel,
            shortenedUrlUI = shortenedUrlUI,
            originalUrl = originalUrl
        )

        // Act
        shortLinkListViewModel.onShortUrl(originalUrl)
        shortLinkListViewModel.state.asLiveData().observeForever(stateObserver)

        // Assert
        verify {
            stateObserver.onChanged(
                ShortLinkListState(
                    isLoading = false,
                    error = null,
                    shortLinks = listOf(shortenedUrlUI),
                )
            )
        }
    }

    @Test
    fun onShortUrl_withInvalidOriginalUrl_ShouldReturnAnErrorState(): Unit = runBlocking {
        // Arrange
        val error = "Algo deu errado"
        coEvery { linkShortenerUseCase.createShortUrl(originalUrl) } returns flow {
            throw Exception(
                error
            )
        }

        // Act
        shortLinkListViewModel.onShortUrl(originalUrl)
        shortLinkListViewModel.state.asLiveData().observeForever(stateObserver)

        // Assert
        verify {
            stateObserver.onChanged(
                ShortLinkListState(
                    isLoading = false,
                    error = error,
                    shortLinks = listOf(),
                )
            )
        }
    }

    @Test
    fun onShortUrl_withValidOriginalUrl_ShouldReturnASuccessStateWithTwoItems() = runBlocking {
        // Arrange
        val shortenedUrlModel = makeShortenedUrlModel()
        val shortenedUrlUI = makeShortenedUrlUi()
        prepareScenario(
            shortenedUrlModel = shortenedUrlModel,
            shortenedUrlUI = shortenedUrlUI,
            originalUrl = originalUrl
        )

        // Act
        shortLinkListViewModel.onShortUrl(originalUrl)
        shortLinkListViewModel.onShortUrl(originalUrl)
        shortLinkListViewModel.state.asLiveData().observeForever(stateObserver)

        // Assert
        verify {
            stateObserver.onChanged(
                ShortLinkListState(
                    isLoading = false,
                    error = null,
                    shortLinks = listOf(shortenedUrlUI, shortenedUrlUI),
                )
            )
        }
    }

    private fun prepareScenario(
        shortenedUrlModel: ShortenedUrlModel = makeShortenedUrlModel(),
        shortenedUrlUI: ShortenedUrlUI = makeShortenedUrlUi(),
        originalUrl: String = "https://www.facebook.com"
    ) {
        every { shortLinkModelToShortenedUrlUIMapper.map(any()) } returns shortenedUrlUI
        coEvery { linkShortenerUseCase.createShortUrl(originalUrl) } returns flowOf(
            shortenedUrlModel
        )
    }
}