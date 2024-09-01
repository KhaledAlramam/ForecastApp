package com.khaled.forecastapp.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khaled.forecastapp.home.domain.api.WeatherUi

@Composable
fun WeatherItem(
    weatherItem: WeatherUi,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = MaterialTheme.colorScheme.secondary)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = weatherItem.weather.main, color = MaterialTheme.colorScheme.primary)
            Text(text = weatherItem.date, color = MaterialTheme.colorScheme.secondary)
        }
        Text(text = weatherItem.weather.description, color = MaterialTheme.colorScheme.secondary)
    }
}