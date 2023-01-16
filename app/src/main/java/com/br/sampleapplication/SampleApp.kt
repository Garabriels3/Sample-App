package com.br.sampleapplication

import android.app.Application
import com.br.sampleapplication.di.viewModelModule
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
            modules(viewModelModule)
        }
    }
}