package com.br.gpt3assistant.di

import com.br.gpt3assistant.presentation.audioconverter.SpeechRecognitionService
import com.br.gpt3assistant.presentation.ui.chatspeech.ChatSpeechViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { ChatSpeechViewModel(SpeechRecognitionService(androidContext()), get()) }
}