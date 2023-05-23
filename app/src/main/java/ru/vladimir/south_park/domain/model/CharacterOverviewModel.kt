package ru.vladimir.south_park.domain.model

data class CharacterOverviewModel(
    val id: String,
    val name: String,
    val age: Int?,
    val sex: String,
    val hair_color: String,
    val occupation: String,
    val religion: String,
    val voiced_by: String,
)
