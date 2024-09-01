package com.khaled.forecastapp.home.domain.api

data class WeatherUi(
    val weather: Weather,
    val date: String
)

fun WeatherResponseDTO.toWeatherUiList(): List<WeatherUi> {
    return list.map {
        WeatherUi(
            it.weather.first(),
            it.dt_txt
        )
    }
}