package com.khaled.forecastapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khaled.forecastapp.home.components.CitySelector
import com.khaled.forecastapp.home.components.WeatherItem
import com.khaled.forecastapp.home.domain.City
import com.khaled.forecastapp.home.presentation.HomeViewModel
import com.khaled.forecastapp.util.ResourceHandlingView

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = viewModel()
    val weatherState by viewModel.weatherFlow.collectAsState()
    var selectedCity: City? by remember {
        mutableStateOf(null)
    }
    LaunchedEffect(key1 = selectedCity) {
        selectedCity?.let {
            viewModel.getWeatherByCity(it)
        }
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CitySelector(
            viewModel.getCities(), {
                selectedCity = it
            }, modifier = Modifier.height(30.dp)
        )
        ResourceHandlingView(resourceState = weatherState, onSuccessView = { list ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(list.size) {
                    WeatherItem(list[it])
                }
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}