package com.khaled.forecastapp.home.domain


import com.squareup.moshi.Json

data class City(
    @Json(name = "cityNameAr")
    val cityNameAr: String,
    @Json(name = "cityNameEn")
    val cityNameEn: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
)