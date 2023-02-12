package com.example.rickandmortydictionary.domain.repository

import com.example.rickandmortydictionary.domain.api.CharacterDetails
import com.example.rickandmortydictionary.domain.api.CharacterResponse
import com.example.rickandmortydictionary.domain.api.CharacterSmall

interface CharacterRepository {
    suspend fun searchCharacters(name: String, page: Int): CharacterResponse

    suspend fun getCharacterById(id: Int): CharacterDetails
}