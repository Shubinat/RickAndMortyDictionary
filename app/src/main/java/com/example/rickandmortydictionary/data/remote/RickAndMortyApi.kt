package com.example.rickandmortydictionary.data.remote

import com.example.rickandmortydictionary.domain.api.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun searchCharacters(@Query("name") name: String, @Query("page") page : Int): CharacterResponse
    @GET("location")
    suspend fun getLocations(@Query("page") page : Int): Call<Any>
    @GET("episode")
    suspend fun getEpisodes(@Query("page") page : Int): Call<Any>
}