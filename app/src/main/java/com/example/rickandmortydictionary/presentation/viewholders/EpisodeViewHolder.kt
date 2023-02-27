package com.example.rickandmortydictionary.presentation.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortydictionary.databinding.EpisodeItemBinding
import com.example.rickandmortydictionary.domain.api.Episode

class EpisodeViewHolder(private val binding: EpisodeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(episode: Episode) {
        with(binding) {
            tvEpisodeNumber.text = "Episode $episode.id"
            tvEpisodeName.text = episode.name
        }
    }

    fun clear() {
        with(binding) {
            tvEpisodeNumber.text = ""
            tvEpisodeName.text = ""
        }
    }
}