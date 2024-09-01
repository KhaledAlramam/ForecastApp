package com.khaled.forecastapp.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khaled.forecastapp.R
import com.khaled.forecastapp.home.domain.City
import java.util.Locale

@Composable
fun CitySelector(
    citiesList: List<City>, onCitySelected: (City) -> Unit, modifier: Modifier = Modifier
) {
    var selectedCity by remember { mutableStateOf<City?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val locale = Locale.getDefault().language
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Row(modifier = Modifier
            .clickable {
                expanded = true
            }
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = if (selectedCity == null) stringResource(id = R.string.select_city) else {
                    if (locale == "ar") selectedCity?.cityNameAr else selectedCity?.cityNameEn
                }
                    ?: "",
            )
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            citiesList.forEach { city ->
                val text = if (locale == "ar") city.cityNameAr else city.cityNameEn
                DropdownMenuItem(text = {
                    Text(text = text, color = MaterialTheme.colorScheme.primary)
                }, onClick = {
                    expanded = false
                    selectedCity = city
                    onCitySelected(city)
                })

            }
        }
    }
}

@Preview
@Composable
private fun PreviewCitySelector() {
    CitySelector(listOf(
        City(
            cityNameAr = "Clemen", cityNameEn = "Poarisia", id = 8850, lat = 4.5, lon = 6.7
        )
    ), {})
}