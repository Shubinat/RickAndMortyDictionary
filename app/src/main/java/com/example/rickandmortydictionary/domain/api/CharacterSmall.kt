package com.example.rickandmortydictionary.domain.api

import com.google.gson.annotations.SerializedName

data class CharacterSmall(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val imageUrl: String,
)