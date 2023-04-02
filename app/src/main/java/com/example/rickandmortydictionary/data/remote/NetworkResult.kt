package com.example.rickandmortydictionary.data.remote

class NetworkResult<T> private constructor(
    val status: Status,
    val data: T?,
    val message: String? = null,
) {
    companion object {
        fun <T> success(data: T) = NetworkResult(Status.SUCCESS, data)
        fun <T> error(msg: String?, data: T? = null) = NetworkResult(Status.ERROR, data, msg)
    }
}