package com.example.rickandmortydictionary.data.remote

class LoadingState<T> private constructor(
    val status: Status,
    val data: T?,
    val message: String? = null,
) {
    companion object {
        fun <T> success(data: T) = LoadingState(Status.SUCCESS, data)
        fun <T> loading(data: T?) = LoadingState(Status.LOADING, data)
        fun <T> error(data: T?, msg: String?) = LoadingState(Status.ERROR, data, msg)
    }
}