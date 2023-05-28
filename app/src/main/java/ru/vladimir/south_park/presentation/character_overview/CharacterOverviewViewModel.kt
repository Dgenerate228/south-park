package ru.vladimir.south_park.presentation.character_overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vladimir.south_park.data.network.repository.SouseParkRepository
import ru.vladimir.south_park.domain.model.CharacterOverviewModel

class CharacterOverviewViewModel : ViewModel() {
    val charactersState get() = _charactersState.asStateFlow()
    private val _charactersState =
        MutableStateFlow(CharacterOverviewModel())

    private val souseParkRepository = SouseParkRepository()

    init {
        getCharacterOverview()
    }

    private fun getCharacterOverview() {
        viewModelScope.launch {
            val characters = souseParkRepository.getCharacterOverview()
            _charactersState.emit(characters)
        }
    }

}