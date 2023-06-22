package ru.vladimir.south_park.presentation.episodes_overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vladimir.south_park.R
import ru.vladimir.south_park.common.data.observe
import ru.vladimir.south_park.databinding.FragmentEpisodesOverviewBinding

class EpisodesOverviewFragment : Fragment(R.layout.fragment_episodes_overview) {
    private lateinit var binding: FragmentEpisodesOverviewBinding

    private val viewModel: EpisodesOverviewModel by viewModels()

    private val episodesOverviewAdapter by lazy {
        EpisodesOverviewAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEpisodesOverviewBinding.bind(view)
        observeViewModel()
        initScreen()
    }

    private fun initScreen() {
        binding. .apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodesOverviewAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.charactersState.observe(this) {
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