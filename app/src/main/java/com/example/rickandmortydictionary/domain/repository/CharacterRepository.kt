package com.example.rickandmortydictionary.domain.repository

import com.example.rickandmortydictionary.data.remote.NetworkResult
import com.example.rickandmortydictionary.domain.api.CharacterDetailsResponse
import com.example.rickandmortydictionary.domain.api.CharacterResponse

interface CharacterRepository {
    suspend fun searchCharacters(name: String, page: Int): NetworkResult<CharacterResponse?>

    suspend fun getCharacterById(id: Int): NetworkResult<CharacterDetailsResponse?>
}