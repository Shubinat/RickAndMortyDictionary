package com.example.rickandmortydictionary.di

import android.app.Application
import android.content.Context
import com.example.rickandmortydictionary.data.remote.RickAndMortyApi
import com.example.rickandmortydictionary.data.repository.CharacterRepositoryImpl
import com.example.rickandmortydictionary.data.repository.EpisodeRepositoryImpl
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import com.example.rickandmortydictionary.domain.repository.EpisodeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@DisableInstallInCheck
class RepositoryModule {
    @Provides
    @Singleton
    fun bindCharacterRepository(
        api: RickAndMortyApi,
        @ApplicationContext app: Application
    ): CharacterRepository {
        return CharacterRepositoryImpl(api, app)
    }

    @Provides
    @Singleton
    fun bindEpisodeRepository(
        api: RickAndMortyApi,
        @ApplicationContext app: Application
    ): EpisodeRepository {
        return EpisodeRepositoryImpl(api, app)
    }
}