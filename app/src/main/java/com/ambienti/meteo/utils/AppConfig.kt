package com.ambienti.meteo.utils

import android.app.Application
import com.ambienti.meteo.dependency_injection.networkModule
import com.ambienti.meteo.dependency_injection.repositoryModule
import com.ambienti.meteo.dependency_injection.serializerModule
import com.ambienti.meteo.dependency_injection.storageModule
import com.ambienti.meteo.dependency_injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppConfig : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppConfig)
            modules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                    serializerModule,
                    storageModule,
                    networkModule
                )
            )
        }
    }
}