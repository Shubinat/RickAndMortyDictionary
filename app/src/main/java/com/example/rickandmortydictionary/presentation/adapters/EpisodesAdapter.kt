package com.example.rickandmortydictionary.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortydictionary.databinding.EpisodeItemBinding
import com.example.rickandmortydictionary.domain.api.Episode
import com.example.rickandmortydictionary.presentation.viewholders.EpisodeViewHolder

class EpisodesAdapter(private val episodes: List<Episode>) : RecyclerView.Adapter<EpisodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = EpisodeItemBinding.inflate(LayoutInflater.from(parent.context))
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.bind(episodes[position])
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    override fun onViewRecycled(holder: EpisodeViewHolder) {
        holder.clear()
    }
}