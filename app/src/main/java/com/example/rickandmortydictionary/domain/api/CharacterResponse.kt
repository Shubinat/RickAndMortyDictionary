package com.example.rickandmortydictionary.domain.api

import com.google.gson.annotations.SerializedName

data class CharacterResponse (
    @SerializedName("info")
    val info: ResponseInfo,
    @SerializedName("results")
    val results: List<CharacterSmall>
)