package ru.vladimir.south_park.presentation.episodes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vladimir.south_park.R
import ru.vladimir.south_park.common.data.observe
import ru.vladimir.south_park.databinding.FragmentEpisodesBinding

class EpisodesFragment : Fragment(R.layout.fragment_episodes) {

    private lateinit var binding: FragmentEpisodesBinding

    private val viewModel: EpisodesViewModel by viewModels()

    private val episodesAdapter by lazy {
        EpisodesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEpisodesBinding.bind(view)
        observeViewModel()
        initScreen()
    }

    private fun initScreen() {
        binding.episodesRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodesAdapter
        }

    }

    private fun observeViewModel() {
        viewModel.episodesState.observe(this) {
            binding.episodesRv
        }
    }

}