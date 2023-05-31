package ru.vladimir.south_park.presentation.character_overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vladimir.south_park.R
import ru.vladimir.south_park.common.data.observe
import ru.vladimir.south_park.databinding.FragmentCharacterOverviewBinding

class CharacterOverviewFragment : Fragment(R.layout.fragment_character_overview) {

    private lateinit var binding: FragmentCharacterOverviewBinding

    private val viewModel: CharacterOverviewViewModel by viewModels()

    private val charactersOverviewAdapter by lazy {
        CharacterOverviewAdapter()
    }

    private val episodesAdapter by lazy {
        EpisodesOverviewAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterOverviewBinding.bind(view)
        observeViewModel()
        initScreen()
    }

    private fun initScreen() {
        binding.homeCharactersRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactersOverviewAdapter
        }

        binding.episodeCharactersRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.charactersState.observe(this) {

            episodesAdapter.submitList(it.episodes).hashCode()
            charactersOverviewAdapter.submitList(it.relatives)
            binding.ageGet.text = it.age.toString()
            binding.sexGet.text = it.sex
            binding.nameText.text = it.name
            binding.hairColorGet.text = it.name
            binding.occupationGet.text = it.occupation
            binding.religionGet.text = it.religion
            binding.voicedByGet.text = it.voicedBy.toString()
        }
    }
}
