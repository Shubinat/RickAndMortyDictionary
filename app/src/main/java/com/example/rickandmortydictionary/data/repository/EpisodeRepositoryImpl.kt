package com.example.rickandmortydictionary.data.repository

import android.app.Application
import com.example.rickandmortydictionary.R
import com.example.rickandmortydictionary.data.remote.NetworkResult
import com.example.rickandmortydictionary.data.remote.RickAndMortyApi
import com.example.rickandmortydictionary.data.remote.toNetworkResult
import com.example.rickandmortydictionary.domain.api.Episode
import com.example.rickandmortydictionary.domain.repository.EpisodeRepository
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi,
    private val app: Application
) :
    EpisodeRepository {
    override suspend fun getEpisodeById(id: Int): NetworkResult<Episode?> {
        return api.getEpisode(id = id).toNetworkResult(app)
    }
}