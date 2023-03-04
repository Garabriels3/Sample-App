package com.br.shorturlapp

import android.app.Application
import com.br.di.dataModule
import com.br.di.domainModule
import com.br.di.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

class ShortUrlApp : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@ShortUrlApp)
            // Load modules
            modules(dataModule, domainModule, serviceModule)
        }
    }
}