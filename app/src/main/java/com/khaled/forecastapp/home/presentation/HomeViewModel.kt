package com.khaled.forecastapp.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khaled.forecastapp.home.domain.City
import com.khaled.forecastapp.home.domain.api.WeatherResponseDTO
import com.khaled.forecastapp.home.domain.repo.HomeRepo
import com.khaled.forecastapp.util.Resource
import com.khaled.forecastapp.util.cityList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepo) : ViewModel() {
    private var _weatherFlow = MutableStateFlow<Resource<WeatherResponseDTO>>(Resource.Idle)
    val weatherFlow = _weatherFlow

    fun getWeatherByCity(city: City) {
        _weatherFlow.value = Resource.Loading
        viewModelScope.launch {
            val response = repo.getWeatherByCity(city)
            _weatherFlow.value = response
        }
    }

    fun getCities(): List<City> = cityList
}