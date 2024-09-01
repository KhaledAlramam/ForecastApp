package com.khaled.forecastapp.home.domain.api


import com.squareup.moshi.Json

data class Sys(
    @Json(name = "pod")
    val pod: String
)