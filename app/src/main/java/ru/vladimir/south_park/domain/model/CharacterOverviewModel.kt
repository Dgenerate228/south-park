package ru.vladimir.south_park.domain.model


data class CharacterOverviewModel(
    val id: Int = 0,
    val name: String = "",
    val age: Int? = null,
    val sex: String = "",
    val hairColor: String = "",
    val occupation: String = "",
    val religion: String = "",
    val voicedBy: String? = null,
    val relatives: List<RelativeModel> = emptyList(),
    val episodes: List<String> = emptyList()
)
