package com.khaled.forecastapp.home.domain.api

data class WeatherResponseDTO(
//    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<BaseWeatherItem>,
    val message: Int
)