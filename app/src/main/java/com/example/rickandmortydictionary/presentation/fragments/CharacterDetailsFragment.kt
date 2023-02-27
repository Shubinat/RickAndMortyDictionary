package com.example.rickandmortydictionary.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.rickandmortydictionary.databinding.FragmentCharacterDetailsBinding
import com.example.rickandmortydictionary.presentation.adapters.EpisodesAdapter
import com.example.rickandmortydictionary.presentation.viewmodels.DetailsViewModel
import com.example.rickandmortydictionary.presentation.viewmodels.MainViewModel
import com.example.rickandmortydictionary.presentation.viewmodels.factories.DetailsViewModelFactory
import com.squareup.picasso.Picasso


class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding: FragmentCharacterDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentCharacterDetailsBinding == null")

    private val args by navArgs<CharacterDetailsFragmentArgs>()

    private val viewModel: DetailsViewModel by lazy {
        val viewModelFactory = DetailsViewModelFactory(args.characterId)
        ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.character.observe(viewLifecycleOwner) {
            with(binding) {
                Picasso.get().load(it.imageUrl).into(imagePhoto)
                tvName.text = it.name
                tvStatusValue.text = it.status
                tvSpeciesValue.text = it.species
                tvGenderValue.text = it.gender
                tvOriginValue.text = it.origin.name
                tvLocationValue.text = it.location.name
                rvEpisodes.adapter = EpisodesAdapter(it.episodes)
            }
        }
        viewModel.loadCharacter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}