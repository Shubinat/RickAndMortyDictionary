package com.example.rickandmortydictionary.di

import com.example.rickandmortydictionary.data.repository.CharacterRepositoryImpl
import com.example.rickandmortydictionary.data.repository.EpisodeRepositoryImpl
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import com.example.rickandmortydictionary.domain.repository.EpisodeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCharacterRepository(repositoryImpl: CharacterRepositoryImpl): CharacterRepository

    @Binds
    @Singleton
    abstract fun bindEpisodeRepository(repositoryImpl: EpisodeRepositoryImpl): EpisodeRepository
}