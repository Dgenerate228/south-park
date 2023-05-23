package ru.vladimir.south_park.data.network.response.characters

import com.google.gson.annotations.SerializedName

data class CharacterResponseOverview(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int?,
    @SerializedName("sex") val sex: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("occupation") val occupation: String,
    @SerializedName("religion") val religion: String,
    @SerializedName("voiced_by") val voiced_by: String
)

