package com.ambienti.meteo.network.api

import com.ambienti.meteo.data.RemoteLocation
import com.ambienti.meteo.data.RemoteWeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    companion object{
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY = "c35d0f3606504221ba3221552242605"
    }

    @GET("search.json")
    suspend fun searchLocation(
        @Query("key") key: String = API_KEY,
        @Query("q") query: String
    ): Response<List<RemoteLocation>>

    @GET("forecast.json")
    suspend fun getWeatherData(
        @Query("key") key: String = API_KEY,
        @Query("q") query: String
    ): Response<RemoteWeatherData>
}