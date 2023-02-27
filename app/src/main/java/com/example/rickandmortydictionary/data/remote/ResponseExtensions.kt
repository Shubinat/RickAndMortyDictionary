package com.example.rickandmortydictionary.data.remote

import android.app.Application
import com.example.rickandmortydictionary.R
import retrofit2.Response

fun <T> Response<T>.toNetworkResult(application: Application) : NetworkResult<T?> {
    return if (this.isSuccessful) {
        val responseBody = this.body()
        if (responseBody != null) {
            NetworkResult.success(responseBody)
        } else {
            NetworkResult.error(application.getString(R.string.network_no_data_error))
        }
    } else {
        NetworkResult.error(application.getString(R.string.network_code_error))
    }
}