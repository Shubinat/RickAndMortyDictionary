package com.example.rickandmortydictionary.domain.api

import com.google.gson.annotations.SerializedName

data class CharacterDetailsResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: Location,
    @SerializedName("location")
    val location: Location,
    @SerializedName("episode")
    val episodes: List<String>,
    @SerializedName("image")
    val imageUrl: String
)