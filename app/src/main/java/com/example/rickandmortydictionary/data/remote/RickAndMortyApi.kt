package com.example.rickandmortydictionary.data.remote

import com.example.rickandmortydictionary.domain.api.CharacterDetailsResponse
import com.example.rickandmortydictionary.domain.api.CharacterResponse
import com.example.rickandmortydictionary.domain.api.Episode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun searchCharacters(@Query("name") name: String, @Query("page") page : Int): Response<CharacterResponse>
    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id : Int): Response<CharacterDetailsResponse>
    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") id : Int): Response<Episode>
}