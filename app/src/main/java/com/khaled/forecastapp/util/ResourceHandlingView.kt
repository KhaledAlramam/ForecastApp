package com.khaled.forecastapp.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T> ResourceHandlingView(
    resourceState: Resource<T>,
    onSuccessView: @Composable (T) -> Unit,
    loadingView: @Composable () -> Unit = {
        CircularProgressIndicator()
    },
    onErrorView: @Composable (String?) -> Unit = {
        Text(text = it ?: "")
    },
) {
    when (resourceState) {
        is Resource.Error -> {
            onErrorView(resourceState.msg)
            // Handle error state
        }

        Resource.Idle -> {

            // Handle idle state
        }

        Resource.Loading -> {

            loadingView()
            // Handle loading state
        }

        is Resource.NetworkError -> {
            // Handle network error state
        }

        is Resource.ServerError -> {
            // Handle server error state
        }

        is Resource.Success -> {
            resourceState.data?.let {
                onSuccessView(it)
            }
        }
    }
}
