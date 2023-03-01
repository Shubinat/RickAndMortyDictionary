package com.example.rickandmortydictionary

import android.app.Application
import com.example.rickandmortydictionary.di.AppComponent
import com.example.rickandmortydictionary.di.AppModule
import com.example.rickandmortydictionary.di.DaggerAppComponent
import dagger.internal.DaggerCollections
import javax.inject.Singleton

class RickAndMortyDictionaryApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)
    }
}
