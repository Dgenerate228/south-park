package ru.vladimir.south_park.data.network.response.characters

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int?,
    @SerializedName("sex") val sex: String
)
