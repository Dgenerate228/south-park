package ru.vladimir.south_park.data.network.response.episodes_overview

import com.google.gson.annotations.SerializedName

class EpisodesOverviewModel(
    @SerializedName("data") val episodes: List<EpisodesOverviewResponse>)