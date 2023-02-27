package com.example.rickandmortydictionary.domain.api

import com.google.gson.annotations.SerializedName

data class CharacterDetails(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val episodes: List<Episode>,
    val imageUrl: String
)
