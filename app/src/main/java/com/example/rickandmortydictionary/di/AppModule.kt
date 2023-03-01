package com.example.rickandmortydictionary.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton


@Module
@DisableInstallInCheck
class AppModule(val application: Application) {
    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext() = application
}