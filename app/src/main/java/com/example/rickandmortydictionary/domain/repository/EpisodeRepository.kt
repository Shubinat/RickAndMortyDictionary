package com.example.rickandmortydictionary.domain.repository

import com.example.rickandmortydictionary.domain.api.Episode

interface EpisodeRepository {
    fun getEpisodeById(id: Int): Episode
}