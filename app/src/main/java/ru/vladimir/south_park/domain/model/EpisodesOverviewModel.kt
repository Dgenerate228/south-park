package ru.vladimir.south_park.domain.model

data class EpisodesOverviewModel (
    val id: Int = 0,
    val name: String = "",
    val season: Int = 0,
    val episode: Int = 0,
    val airDate: String = "",
    val wikiUrl: String = "",
    val thumbnailUrl: String = "",
    val description: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    val characters: List<String> = emptyList()
        )