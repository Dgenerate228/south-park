package ru.vladimir.south_park.data.network.response.character_overview

import com.google.gson.annotations.SerializedName

data class Relatives(
    @SerializedName("url") val url: String,
    @SerializedName("relation") val relation: String,
)
