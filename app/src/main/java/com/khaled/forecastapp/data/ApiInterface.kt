package com.khaled.forecastapp.data

import com.khaled.forecastapp.home.domain.api.WeatherResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/data/2.5/forecast")
    suspend fun getWeatherByCity(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String
    ): Response<WeatherResponseDTO>
}