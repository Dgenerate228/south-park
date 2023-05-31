package ru.vladimir.south_park.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vladimir.south_park.data.network.repository.SouseParkRepository
import ru.vladimir.south_park.domain.model.CharacterModel

class HomeViewModel : ViewModel() {

    val charactersState get() = _charactersState.asStateFlow()
    private val _charactersState = MutableStateFlow(emptyList<CharacterModel>())

    private val souseParkRepository = SouseParkRepository()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            val characters = souseParkRepository.getCharacters()
            _charactersState.emit(characters)
        }
    }
}