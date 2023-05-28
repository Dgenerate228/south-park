package ru.vladimir.south_park.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vladimir.south_park.R
import ru.vladimir.south_park.common.data.observe
import ru.vladimir.south_park.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    private val charactersAdapter by lazy {
        CharactersAdapter(onItemClick = { openCharacterOverviewFragment(it) })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        observeViewModel()
        initScreen()
    }

    private fun initScreen() {
        binding.homeCharactersRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactersAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.charactersState.observe(this) { characters ->
            charactersAdapter.submitList(characters)
        }
    }

    private fun openCharacterOverviewFragment(characterId: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToCharacterOverviewFragment(characterId)
        )
    }
}