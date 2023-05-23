package ru.vladimir.south_park.domain.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val age: Int?,
    val sex: String
)