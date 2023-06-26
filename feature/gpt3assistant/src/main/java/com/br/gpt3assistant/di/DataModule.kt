package com.br.gpt3assistant.di

import com.br.data.apiconfig.apiclient.HttpClient.makeService
import com.br.gpt3assistant.data.datasource.remote.ChatGptAssistantRemoteDataSource
import com.br.gpt3assistant.data.datasource.remote.ChatGptAssistantRemoteDataSourceImpl
import com.br.gpt3assistant.data.googlespeechtext.texttospeech.GoogleTextToSpeechConverterImpl
import com.br.gpt3assistant.data.service.ChatGPTService
import com.br.gpt3assistant.domain.googlespeechtext.GoogleTextToSpeechConverter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { makeService<ChatGPTService>() }

    factory<GoogleTextToSpeechConverter> { GoogleTextToSpeechConverterImpl(androidContext()) }
    factory<ChatGptAssistantRemoteDataSource> { ChatGptAssistantRemoteDataSourceImpl(get()) }
}