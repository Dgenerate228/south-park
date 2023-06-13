package ru.vladimir.south_park.data.network.response.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesResponseModel(
    @SerializedName("data") val episodes: List<EpisodesResponse>)