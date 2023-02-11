package com.example.rickandmortydictionary.di

import com.example.rickandmortydictionary.data.repository.CharacterRepositoryImpl
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
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
    abstract fun bindRepository(repositoryImpl: CharacterRepositoryImpl): CharacterRepository
}