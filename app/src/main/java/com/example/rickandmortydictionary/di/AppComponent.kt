package com.example.rickandmortydictionary.di

import android.app.Application
import com.example.rickandmortydictionary.presentation.viewmodels.DetailsViewModel
import com.example.rickandmortydictionary.presentation.viewmodels.MainViewModel
import dagger.Component
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope
import javax.inject.Singleton


@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])
@Singleton
interface AppComponent {

    fun inject(application: Application)

    fun inject(viewModel: DetailsViewModel)

    fun inject(viewModel: MainViewModel)
}