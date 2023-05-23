package ru.vladimir.south_park.domain.model

data class CharacterModel(
    val id: String,
    val name: String,
    val age: Int?,
    val sex: String
)