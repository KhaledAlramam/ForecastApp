package com.khaled.forecastapp.util

sealed class Resource<out T>(data: T?) {

    object Loading : Resource<Nothing>(null)
    object Idle : Resource<Nothing>(null)
    data class Success<out T>(val data: T) : Resource<T>(data)
    data class Error<out T>(val msg: String?, val responseCode: String? = null) : Resource<T>(null)
    class NetworkError<out T> : Resource<T>(null)
    class ServerError<out T> : Resource<T>(null)
}