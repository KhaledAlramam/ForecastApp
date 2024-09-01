package com.khaled.forecastapp.home.domain.api


import com.squareup.moshi.Json

data class Clouds(
    @Json(name = "all")
    val all: Int
)