package com.example.rickandmortydictionary.data.repository

import com.example.rickandmortydictionary.data.remote.RickAndMortyApi
import com.example.rickandmortydictionary.domain.api.CharacterDetails
import com.example.rickandmortydictionary.domain.api.CharacterResponse
import com.example.rickandmortydictionary.domain.api.CharacterSmall
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val api : RickAndMortyApi) : CharacterRepository {
    override suspend fun searchCharacters(name: String, page: Int): CharacterResponse {
        return api.searchCharacters(name, page)
    }

    override suspend fun getCharacterById(id: Int): CharacterDetails {
        TODO("Not yet implemented")
    }
}