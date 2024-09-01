package com.khaled.forecastapp.home.domain.repo

import com.khaled.forecastapp.home.domain.City
import com.khaled.forecastapp.home.domain.api.WeatherResponseDTO
import com.khaled.forecastapp.util.Resource

interface HomeRepo {
    suspend fun getWeatherByCity(city: City): Resource<WeatherResponseDTO>
}