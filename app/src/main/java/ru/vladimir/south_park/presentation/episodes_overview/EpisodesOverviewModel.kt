package ru.vladimir.south_park.presentation.episodes_overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vladimir.south_park.data.network.repository.SouseParkRepository
import ru.vladimir.south_park.domain.model.EpisodesOverviewModel

class EpisodesOverviewModel : ViewModel() {
    val charactersState get() = _charactersState.asStateFlow()
    private val _charactersState = MutableStateFlow(EpisodesOverviewModel())

    private val souseParkRepository = SouseParkRepository()

    init {
        getEpisodesOverview()
    }

    private fun getEpisodesOverview() {
        viewModelScope.launch {
            val episodes = souseParkRepository.getEpisodesOverview()
            _charactersState.emit(episodes)
        }
    }
}