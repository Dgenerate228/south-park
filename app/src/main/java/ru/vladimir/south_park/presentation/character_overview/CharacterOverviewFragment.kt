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

    private val charactersOverviwAdapter by lazy {
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
        initEpisodes()


        binding.nameText.text
    }

    private fun initScreen() {
        binding.homeCharactersRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = charactersOverviwAdapter
        }
    }

    private fun initEpisodes() {
        binding.episodeCharactersRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodesAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.charactersState.observe(this) {

            episodesAdapter.submitList(it.episodes)
            charactersOverviwAdapter.submitList(it.relatives)

            binding.ageText.text = it.age.toString()
            binding.nameText.text = it.name
            binding.hairColorText.text = it.name
            binding.occupationText.text = it.occupation
            binding.religionText.text = it.religion
            binding.voicedByText.text = it.voicedBy
        }
    }
}
