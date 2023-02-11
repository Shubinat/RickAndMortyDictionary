package com.example.rickandmortydictionary.domain.api

import com.google.gson.annotations.SerializedName


data class ResponseInfo(
    @SerializedName("count")
    val count: Int,
    @SerializedName("pages")
    val pages: Int
)