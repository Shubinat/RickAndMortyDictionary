package com.example.rickandmortydictionary.presentation.viewholders

import android.content.res.Resources
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortydictionary.databinding.CharacterItemBinding
import com.example.rickandmortydictionary.domain.api.CharacterSmall
import com.squareup.picasso.Picasso

class CharacterViewHolder(private val binding: CharacterItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterSmall, position: Int, onItemClickListener: ((Int) -> Unit)?) {
        with(binding) {
            if (position == 0) {
                setupTopMargin(FIRST_TOP_MARGIN)
            }

            tvName.text = character.name
            tvGenderValue.text = character.gender
            tvSpeciesValue.text = character.species
            tvStatusValue.text = character.status
            cvElement.setOnClickListener {
                onItemClickListener?.invoke(character.id)
            }
            Picasso.get().load(character.imageUrl).into(imgPhoto)
        }
    }

    private fun setupTopMargin(topMargin: Float) {
        val r: Resources = Resources.getSystem()
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            topMargin,
            r.displayMetrics
        )
        val margins = binding.cvElement.layoutParams as ViewGroup.MarginLayoutParams
        margins.topMargin = px.toInt()
    }

    fun clear() {
        with(binding) {
            tvName.text = ""
            tvGenderValue.text = ""
            tvSpeciesValue.text = ""
            tvStatusValue.text = ""
            setupTopMargin(DEFAULT_TOP_MARGIN)
        }
    }

    companion object {
        private const val DEFAULT_TOP_MARGIN = 8F
        private const val FIRST_TOP_MARGIN = 84F
    }
}