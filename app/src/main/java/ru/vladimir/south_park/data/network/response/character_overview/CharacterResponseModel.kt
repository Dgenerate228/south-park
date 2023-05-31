package ru.vladimir.south_park.data.network.response.character_overview

import com.google.gson.annotations.SerializedName

data class CharacterResponseModel(@SerializedName("data") val data: CharacterResponse)
