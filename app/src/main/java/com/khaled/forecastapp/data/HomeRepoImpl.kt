package com.khaled.forecastapp.data

import com.khaled.forecastapp.BuildConfig
import com.khaled.forecastapp.home.domain.City
import com.khaled.forecastapp.home.domain.api.WeatherResponseDTO
import com.khaled.forecastapp.home.domain.repo.HomeRepo
import com.khaled.forecastapp.util.NetworkUtil
import com.khaled.forecastapp.util.Resource
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(private val apiInterface: ApiInterface) : HomeRepo {
    override suspend fun getWeatherByCity(city: City): Resource<WeatherResponseDTO> {
        return NetworkUtil.callAPI {
            apiInterface.getWeatherByCity(
                lat = city.lat, lon = city.lon, apiKey = BuildConfig.API_KEY
            )
        }
    }
}