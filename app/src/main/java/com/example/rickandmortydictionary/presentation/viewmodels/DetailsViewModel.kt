package com.example.rickandmortydictionary.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortydictionary.data.remote.NetworkResult
import com.example.rickandmortydictionary.data.remote.Status
import com.example.rickandmortydictionary.domain.api.CharacterDetails
import com.example.rickandmortydictionary.domain.api.CharacterDetailsResponse
import com.example.rickandmortydictionary.domain.api.Episode
import com.example.rickandmortydictionary.domain.repository.CharacterRepository
import com.example.rickandmortydictionary.domain.repository.EpisodeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel(private val characterId: Int) : ViewModel() {

    @Inject
    lateinit var characterRepository: CharacterRepository

    @Inject
    lateinit var episodeRepository: EpisodeRepository

    private val _isBusy = MutableLiveData(false)
    val isBusy: LiveData<Boolean>
        get() = _isBusy

    private val _character: MutableLiveData<CharacterDetails> = MutableLiveData()
    val character: LiveData<CharacterDetails>
        get() = _character


    init {

    }

    fun loadCharacter() {
        val operation = viewModelScope.async(Dispatchers.IO) {
            characterRepository.getCharacterById(characterId)
        }

        viewModelScope.launch(Dispatchers.Main) {
            delay(300)
            if (operation.isActive) {
                try {
                    _isBusy.value = true
                    val response = operation.await()
                    onLoadCharacter(response)
                } catch (exception: Exception) {
                    //
                } finally {
                    _isBusy.value = false
                }
            } else {
                try {
                    val response = operation.await()
                    onLoadCharacter(response)
                } catch (exception: Exception) {
                    val ex = exception
                }
            }

        }
    }

    private fun onLoadCharacter(characterResult: NetworkResult<CharacterDetailsResponse?>) {
        when (characterResult.status) {
            Status.SUCCESS -> {
                loadEpisodes(characterResult.data!!)
            }
            Status.ERROR -> {}
        }
    }

    private fun loadEpisodes(characterResult: CharacterDetailsResponse) {
        val episodes = mutableListOf<Episode>()
        val characterDetails = CharacterDetails(
            characterResult.id,
            characterResult.name,
            characterResult.status,
            characterResult.species,
            characterResult.gender,
            characterResult.origin,
            characterResult.location,
            episodes,
            characterResult.imageUrl
        )
        val episodesIds = characterResult.episodes.map { it.split('/').last().toInt() }
        for (episodeId in episodesIds) {
            viewModelScope.launch(Dispatchers.IO) {
                val episode = episodeRepository.getEpisodeById(episodeId)
                when (episode.status) {
                    Status.SUCCESS -> {
                        episodes.add(episode.data!!)
                    }
                    Status.ERROR -> {}
                }
            }
        }
        _character.value = characterDetails
    }
}