package com.ambienti.meteo.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ambienti.meteo.data.RemoteLocation
import com.ambienti.meteo.network.repository.WeatherDataRepository
import kotlinx.coroutines.launch

class LocationViewModel(private val weatherDataRepository: WeatherDataRepository): ViewModel() {

    private val _searchResult = MutableLiveData<SearchResultDataState>()
    val searchResult: LiveData<SearchResultDataState> get() = _searchResult

    fun searchLocation(query: String){
        viewModelScope.launch {
            emitSearchResultUiState(isLoading = true)
            val searchResult = weatherDataRepository.searchLocation(query)
            if(searchResult.isNullOrEmpty()){
                emitSearchResultUiState(error = "Posizione non trovata, riprova.")
            }else{
                emitSearchResultUiState(location = searchResult)
            }
        }
    }

    private fun emitSearchResultUiState(
        isLoading: Boolean = false,
        location: List<RemoteLocation>? = null,
        error: String? = null
    ){
        val searchResultDataState = SearchResultDataState(isLoading, location, error)
        _searchResult.value = searchResultDataState
    }

    data class SearchResultDataState(
        val isLoading: Boolean,
        val location: List<RemoteLocation>?,
        val error: String?
    )
}