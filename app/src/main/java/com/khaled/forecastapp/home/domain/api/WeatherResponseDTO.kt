package com.khaled.forecastapp.home.domain.api


import com.squareup.moshi.Json

data class WeatherResponseDTO(
    @Json(name = "city")
    val city: WeatherCity,
    @Json(name = "cnt")
    val cnt: Int,
    @Json(name = "cod")
    val cod: String,
    @Json(name = "list")
    val list: List<WeatherParent>,
    @Json(name = "message")
    val message: Int
)