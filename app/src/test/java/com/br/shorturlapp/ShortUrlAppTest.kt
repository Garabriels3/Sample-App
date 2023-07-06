package com.br.shorturlapp

import com.br.data.datasource.remote.linkshortener.LinkShortenerRemoteDataSource
import com.br.data.service.LinkShortenerService
import com.br.di.dataModule
import com.br.di.domainModule
import com.br.di.presentationModule
import com.br.domain.repository.LinkShortenerRepository
import com.br.domain.usecase.linkshortener.LinkShortenerUseCase
import com.br.presentation.shortlinklist.ShortLinkListViewModel
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get

class ShortUrlAppTest : KoinTest {

    @Before
    fun setup() {
        startKoin {
            modules(presentationModule, dataModule, domainModule)
        }
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun testAllDependenciesInjected_ShouldCreateAllInstances() {
        val linkShortenerService: LinkShortenerService = get()
        val linkShortenerRemoteDataSource: LinkShortenerRemoteDataSource = get()
        val linkShortenerUseCase: LinkShortenerUseCase = get()
        val linkShortenerRepository: LinkShortenerRepository = get()
        val shortLinkListViewModel: ShortLinkListViewModel = get()

        assertNotNull(linkShortenerService)
        assertNotNull(linkShortenerRemoteDataSource)
        assertNotNull(linkShortenerRepository)
        assertNotNull(linkShortenerUseCase)
        assertNotNull(shortLinkListViewModel)
    }
}