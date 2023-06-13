package ru.vladimir.south_park.presentation.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vladimir.south_park.data.network.repository.SouseParkRepository
import ru.vladimir.south_park.domain.model.EpisodesModel

class EpisodesViewModel: ViewModel() {

    val episodesState get() = _episodesState.asStateFlow()
    private val _episodesState = MutableStateFlow(emptyList<EpisodesModel>())

    private val souseParkRepository = SouseParkRepository()

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        viewModelScope.launch {
            val episodes = souseParkRepository.getEpisodes()
            _episodesState.emit(episodes)
        }
    }
}