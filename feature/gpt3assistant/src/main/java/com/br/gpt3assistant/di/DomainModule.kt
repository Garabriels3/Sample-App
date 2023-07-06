package com.br.gpt3assistant.di

import com.br.gpt3assistant.domain.converterfacade.AudioConverterFacade
import com.br.gpt3assistant.domain.converterfacade.AudioConverterImpl
import com.br.gpt3assistant.domain.usecase.ChatSpeechUseCase
import com.br.gpt3assistant.domain.usecase.ChatSpeechUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    factory<ChatSpeechUseCase> { ChatSpeechUseCaseImpl() }
    factory<AudioConverterFacade> { AudioConverterImpl(get()) }
}