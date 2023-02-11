package com.example.rickandmortydictionary.domain.repository

import com.example.rickandmortydictionary.domain.api.CharacterResponse

interface CharacterRepository {
    suspend fun searchCharacters(name: String, page: Int): CharacterResponse
}