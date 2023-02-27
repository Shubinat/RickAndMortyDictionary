package com.example.rickandmortydictionary.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortydictionary.databinding.CharacterItemBinding
import com.example.rickandmortydictionary.domain.api.CharacterSmall
import com.example.rickandmortydictionary.presentation.viewholders.CharacterViewHolder

class CharactersAdapter(private val list: List<CharacterSmall>) : RecyclerView.Adapter<CharacterViewHolder>() {

    var onItemClickListener : ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterItemBinding.inflate(LayoutInflater.from(parent.context))
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(list[position], position, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onViewRecycled(holder: CharacterViewHolder) {
        holder.clear()
    }
}