package com.khaled.forecastapp.home.domain.api

data class BaseWeatherItem(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain?,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
)