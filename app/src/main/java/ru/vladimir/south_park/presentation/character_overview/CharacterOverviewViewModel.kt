package ru.vladimir.south_park.presentation.character_overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.vladimir.south_park.data.network.repository.SouseParkRepository
import ru.vladimir.south_park.domain.model.CharacterOverviewModel

class CharacterOverviewViewModel: ViewModel() {

    //    Источник данных за которым наблюдаем в MainActivity
    val charactersState get() = _charactersState.asStateFlow()
    private val _charactersState =
        MutableStateFlow(emptyList<CharacterOverviewModel>())

    private val souseParkRepository = SouseParkRepository()

    init {
//        Вызов метода при создании класса
        getCharacterOverview()
    }

    private fun getCharacterOverview() {
        viewModelScope.launch {
//            Запрос в сеть
            val characters = souseParkRepository.getCharacterOverview()
//           Измененеие данных в charactersState
            _charactersState.emit(characters)
//            Оповещение об обнавление данных идёт в месте где вызывается observe
        }
    }

}