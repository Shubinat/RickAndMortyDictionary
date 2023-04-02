package com.example.rickandmortydictionary.data.repository

import android.app.Application
import com.example.rickandmortydictionary.data.remote.NetworkResult
import com.example.rickandmortydictionary.data.remote.RickAndMortyApi
import com.example.rickandmortydictionary.data.remote.toNetworkResult
import com.example.rickandmortydictionary.domain.api.CharacterDetailsResponse
import com.example.rickandmortydictionary.domain.api.CharacterResponse
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi,
    private val app: Application
) : CharacterRepository {
    override suspend fun searchCharacters(
        name: String,
        page: Int
    ): NetworkResult<CharacterResponse?> {
        return api.searchCharacters(name = name, page = page).toNetworkResult(app)
    }

    override suspend fun getCharacterById(id: Int): NetworkResult<CharacterDetailsResponse?> {
        return api.getCharacter(id = id).toNetworkResult(app)
    }
}