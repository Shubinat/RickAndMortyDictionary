package com.example.rickandmortydictionary.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}