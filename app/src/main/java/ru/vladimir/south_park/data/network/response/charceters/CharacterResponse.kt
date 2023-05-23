package ru.vladimir.south_park.data.network.response.charceters

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int?,
    @SerializedName("sex") val sex: String,
    @SerializedName("hair_color") val hairColor: String,
)
