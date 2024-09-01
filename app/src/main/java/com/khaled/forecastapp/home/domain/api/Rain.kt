package com.khaled.forecastapp.home.domain.api


import com.squareup.moshi.Json

data class Rain(
    @Json(name = "3h")
    val h: Double
)