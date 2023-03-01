package com.example.rickandmortydictionary.presentation.viewholders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortydictionary.databinding.EpisodeItemBinding
import com.example.rickandmortydictionary.domain.api.Episode

class EpisodeViewHolder(private val binding: EpisodeItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(episode: Episode) {
        with(binding) {
            tvEpisodeName.text = "Episode ${episode.id}: ${episode.name}"
        }
    }

    fun clear() {
        with(binding) {
            tvEpisodeName.text = ""
        }
    }
}