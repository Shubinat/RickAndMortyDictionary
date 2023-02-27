package com.example.rickandmortydictionary.domain.repository

import com.example.rickandmortydictionary.data.remote.NetworkResult
import com.example.rickandmortydictionary.domain.api.Episode

interface EpisodeRepository {
    suspend fun getEpisodeById(id: Int): NetworkResult<Episode?>
}