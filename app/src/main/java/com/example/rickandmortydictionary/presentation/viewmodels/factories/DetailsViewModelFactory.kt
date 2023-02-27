package com.example.rickandmortydictionary.presentation.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmortydictionary.presentation.viewmodels.DetailsViewModel

class DetailsViewModelFactory(private val characterId: Int) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            DetailsViewModel(characterId) as T
        } else throw RuntimeException("Unknown modelClass:$modelClass")

    }
}