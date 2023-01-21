package com.br.sampleapplication.di

import com.br.sampleapplication.ui.SampleViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { SampleViewModel() }
}