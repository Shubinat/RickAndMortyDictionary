package com.example.rickandmortydictionary.presentation.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickandmortydictionary.databinding.FragmentMainBinding
import com.example.rickandmortydictionary.presentation.adapters.CharactersAdapter
import com.example.rickandmortydictionary.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter

@AndroidEntryPoint
class MainFragment : Fragment() {


    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding == null")

    private val viewModel: MainViewModel by viewModels({ this })


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        setupClickListeners()
        setupSearchView()
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

    private fun setupSearchView() {
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.loadCharacters(query)
                hideKeyboard(requireActivity())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    viewModel.loadCharacters()
                    hideKeyboard(requireActivity())
                }
                return true
            }
        })
    }

    private fun setupClickListeners() {
        binding.buttonPrev.setOnClickListener {
            viewModel.prevPage()
        }

        binding.buttonNext.setOnClickListener {
            viewModel.nextPage()
        }
    }

    private fun observeViewModel() {
        viewModel.characters.observe(viewLifecycleOwner) { it ->
            val characterAdapter = CharactersAdapter(it).apply {
                onItemClickListener = { id ->
                    findNavController().navigate(
                        MainFragmentDirections.actionMainFragmentToCharacterDetailsFragment(id)
                    )
                }
            }

            binding.rvCharacters.adapter = ScaleInAnimationAdapter(characterAdapter).apply {
                setDuration(500)
                setInterpolator(OvershootInterpolator())
                setFirstOnly(false)
            }
        }
        viewModel.hasPreviousPage.observe(viewLifecycleOwner) {
            binding.buttonPrev.isVisible = it
        }
        viewModel.hasNextPage.observe(viewLifecycleOwner) {
            binding.buttonNext.isVisible = it
        }
        viewModel.isBusy.observe(viewLifecycleOwner) {
            binding.frameLoading.isVisible = it
        }
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}