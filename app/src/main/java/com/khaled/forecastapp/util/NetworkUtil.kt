package com.khaled.forecastapp.util

import android.util.Log
import com.squareup.moshi.Moshi
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.net.ssl.SSLException

object NetworkUtil {
    private const val defaultError = "Server error. Please try again later."
    @Suppress("UNCHECKED_CAST")
    suspend fun <T, U> callAPI(
        mapper: (Response<T>) -> U = { it -> it.body()!! as U },
        apiToCall: suspend () -> Response<T>,
    ): Resource<U> {
        return try {
            val response: Response<T> = apiToCall()
            if (response.isSuccessful && response.body() != null) {
                val mappedEntity: U = mapper.invoke(response)
                return Resource.Success(mappedEntity)
            } else {
                val errorBody =
                    response.errorBody()?.string() ?: return Resource.Error(defaultError)
                if (!isValidJson(errorBody)) {
                    return Resource.Error(
                        "Server Error. Please try again.",
                        response.code().toString() ?: ""
                    )
                }
                return Resource.Error("Something went Wrong", "200")
            }
        } catch (e: HttpException) {
            Log.e("TAG", "callAPI: ${e.message}")
            Resource.Error(e.message() ?: defaultError)

        } catch (e: SSLException) {
            Log.e("TAG", "callAPI: ${e.message}")
            return Resource.Error("Server Error. Please try again.")
        } catch (e: IOException) {
            Resource.NetworkError()
        } catch (e: Exception) {
            Log.e("TAG", "callAPI: ${e.message}")
            Resource.Error(e.message ?: defaultError)
        }
    }

    private fun isValidJson(s: String): Boolean {
        return try {
            JSONObject(s)
            true
        } catch (e: JSONException) {
            false
        }
    }
}