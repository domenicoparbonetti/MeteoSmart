package com.ambienti.meteo.dependency_injection

import com.ambienti.meteo.network.repository.WeatherDataRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { WeatherDataRepository(weatherAPI = get()) }
}