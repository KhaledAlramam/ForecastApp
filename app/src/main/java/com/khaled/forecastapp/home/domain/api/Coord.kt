package com.khaled.forecastapp.home.domain.api


import com.squareup.moshi.Json

data class Coord(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
)