package com.example.rickandmortydictionary.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: CharacterRepository
    ) : ViewModel() {

    private val _isBusy = MutableLiveData(false)
    val isBusy: LiveData<Boolean>
        get() = _isBusy

}