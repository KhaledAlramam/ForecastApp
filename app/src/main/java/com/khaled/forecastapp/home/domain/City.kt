package com.khaled.forecastapp.home.domain

data class City(
    val cityNameAr: String,
    val cityNameEn: String,
    val id: Int,
    val lat: Double,
    val lon: Double
)