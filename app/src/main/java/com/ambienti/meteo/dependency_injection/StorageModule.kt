package com.ambienti.meteo.dependency_injection

import com.ambienti.meteo.storage.SharedPreferencesManager
import org.koin.dsl.module

val storageModule = module {
    single { SharedPreferencesManager(context=get(), gson = get()) }
}