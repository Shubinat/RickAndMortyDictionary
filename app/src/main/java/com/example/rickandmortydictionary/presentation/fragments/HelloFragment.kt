package com.example.rickandmortydictionary.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Dimension
import androidx.navigation.fragment.findNavController
import com.example.rickandmortydictionary.R
import com.example.rickandmortydictionary.databinding.FragmentHelloBinding


class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding: FragmentHelloBinding
        get() = _binding ?: throw RuntimeException("FragmentHelloBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(inflater, container, false)
        binding.buttonStart.setOnClickListener {
            findNavController().navigate(HelloFragmentDirections.actionHelloFragmentToMainFragment())
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}