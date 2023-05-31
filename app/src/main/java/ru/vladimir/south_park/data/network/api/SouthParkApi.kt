package ru.vladimir.south_park.data.network.api

import retrofit2.http.GET
import ru.vladimir.south_park.data.network.response.character_overview.CharacterResponseModel
import ru.vladimir.south_park.data.network.response.characters.CharactersResponseModel

interface SouthParkApi {
    @GET("characters/")
    suspend fun getCharacters(): CharactersResponseModel
    @GET("characters/1")
    suspend fun getCharactersOverview(): CharacterResponseModel
}
