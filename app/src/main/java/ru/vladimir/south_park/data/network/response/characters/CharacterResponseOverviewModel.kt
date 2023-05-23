package ru.vladimir.south_park.data.network.response.characters

import com.google.gson.annotations.SerializedName

data class CharactersResponseOverviewModel(
    @SerializedName("data") val characters: List<CharacterResponseOverview>
)