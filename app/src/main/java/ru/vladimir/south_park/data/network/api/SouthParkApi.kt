package ru.vladimir.south_park.data.network.api

import retrofit2.http.GET
import ru.vladimir.south_park.data.network.response.charceters.CharactersResponseModel

interface SouthParkApi {

    @GET("characters/")
    suspend fun getCharacters(): CharactersResponseModel
}
