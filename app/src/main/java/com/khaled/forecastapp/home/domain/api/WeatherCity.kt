package com.khaled.forecastapp.home.domain.api


import com.squareup.moshi.Json

data class WeatherCity(
    @Json(name = "coord")
    val coord: Coord,
    @Json(name = "country")
    val country: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "population")
    val population: Int,
    @Json(name = "sunrise")
    val sunrise: Int,
    @Json(name = "sunset")
    val sunset: Int,
    @Json(name = "timezone")
    val timezone: Int
)