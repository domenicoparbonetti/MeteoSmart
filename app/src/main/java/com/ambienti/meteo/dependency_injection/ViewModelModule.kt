package com.ambienti.meteo.dependency_injection

import com.ambienti.meteo.fragments.home.HomeViewModel
import com.ambienti.meteo.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{HomeViewModel(weatherDataRepository = get())}
    viewModel{ LocationViewModel(weatherDataRepository = get())}
}