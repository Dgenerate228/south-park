package ru.vladimir.south_park.data.network.response.episodes

import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("season") val season: Int,
    @SerializedName("episode") val episode: Int,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("wiki_url") val wikiUrl: String,
    @SerializedName("thumbnail_url") val thumbnailUrl: String,
    @SerializedName("description") val description: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("characters") val characters: List<String>
)