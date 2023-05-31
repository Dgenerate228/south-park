package ru.vladimir.south_park.data.network.response.character_overview

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int?,
    @SerializedName("sex") val sex: String,
    @SerializedName("hair_color") val hairColor: String,
    @SerializedName("voiced_by") val voiced: String?,
    @SerializedName("occupation") val occupation: String,
    @SerializedName("grade") val grade: String?,
    @SerializedName("religion") val religion: String,
    @SerializedName("relatives") val relatives: List<Relatives>,
    @SerializedName("episodes") val episodes: List<String>,
)
