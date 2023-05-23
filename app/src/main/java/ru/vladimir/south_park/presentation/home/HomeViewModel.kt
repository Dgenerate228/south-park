package ru.vladimir.south_park.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vladimir.south_park.data.network.repository.SouseParkRepository
import ru.vladimir.south_park.domain.model.CharacterModel

class HomeViewModel : ViewModel() {

//    Источник данных за которым наблюдаем в MainActivity
    val charactersState get() = _charactersState.asStateFlow()
    private val _charactersState =
        MutableStateFlow(emptyList<CharacterModel>())

    private val souseParkRepository = SouseParkRepository()

    init {
//        Вызов метода при создании класса
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
//            Запрос в сеть
            val characters = souseParkRepository.getCharactersResponse()
//           Измененеие данных в charactersState
            _charactersState.emit(characters)
//            Оповещение об обнавление данных идёт в месте где вызывается observe
        }
    }
}