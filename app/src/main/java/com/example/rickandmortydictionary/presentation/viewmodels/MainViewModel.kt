package com.example.rickandmortydictionary.presentation.viewmodels

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.*
import com.example.rickandmortydictionary.data.remote.NetworkResult
import com.example.rickandmortydictionary.data.remote.Status
import com.example.rickandmortydictionary.domain.api.CharacterResponse
import com.example.rickandmortydictionary.domain.api.CharacterSmall
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CharacterRepository,
) : ViewModel() {

    private var _page: Int = 1
    private var page
        get() = _page
        set(value) {
            if (value != _page) {
                _page = value
                setPagePosition()
            }
        }

    private var _pagesCount = 0
    private var pagesCount
        get() = _pagesCount
        set(value) {
            if (value != _pagesCount) {
                _pagesCount = value
                setPagePosition()
            }
        }

    private var tempSearchRequest = ""

    private val _characters = MutableLiveData<List<CharacterSmall>>(emptyList())
    val characters: LiveData<List<CharacterSmall>>
        get() = _characters

    private val _isBusy = MutableLiveData(false)
    val isBusy: LiveData<Boolean>
        get() = _isBusy


    private val _hasNextPage = MutableLiveData(false)
    val hasNextPage: LiveData<Boolean>
        get() = _hasNextPage

    private val _hasPreviousPage = MutableLiveData(false)
    val hasPreviousPage: LiveData<Boolean>
        get() = _hasPreviousPage

    init {
        loadCharacters()
    }

    private fun setPagePosition() {
        _hasNextPage.value = page < pagesCount
        _hasPreviousPage.value = page > 1
    }

    fun nextPage() {
        if (hasNextPage.value!!)
            page++
        loadCharacters(tempSearchRequest)
    }

    fun prevPage() {
        if (hasPreviousPage.value!!)
            page--
        loadCharacters(tempSearchRequest)
    }

    fun loadCharacters(name: String? = null) {
        val searchText = name ?: ""
        val operation = viewModelScope.async(Dispatchers.IO) {
            repository.searchCharacters(searchText, page)
        }

        viewModelScope.launch(Dispatchers.Main) {
            delay(300)
            if (operation.isActive) {
                try {
                    _isBusy.value = true
                    val response = operation.await()
                    onLoadCharacters(response, searchText)
                } catch (exception: Exception) {
                    //
                } finally {
                    _isBusy.value = false
                }
            } else {
                try {
                    val response = operation.await()
                    onLoadCharacters(response, searchText)
                } catch (exception: Exception) {

                }
            }

        }

    }


    private fun onLoadCharacters(response: NetworkResult<CharacterResponse?>, name: String) {
        if (tempSearchRequest != name) {
            page = 1
        }
        when(response.status) {
            Status.SUCCESS -> {
                with(response.data!!) {
                    _characters.value = results
                    pagesCount = info.pages
                }
                tempSearchRequest = name
            }
            Status.ERROR -> {
                _characters.value = emptyList()
                pagesCount = 0
            }
        }

    }
}
