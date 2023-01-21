package com.br.sampleapplication

import android.app.Application
import com.br.data.di.dataModule
import com.br.data.di.service
import com.br.domain.di.domain
import com.br.presentation.di.presentation
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class SampleApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@SampleApp)
            // Load modules
            modules(presentation, dataModule, domain, service)
        }
    }
}