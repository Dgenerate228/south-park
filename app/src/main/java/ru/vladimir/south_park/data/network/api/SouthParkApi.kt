package ru.vladimir.south_park.data.network.api

import retrofit2.http.GET
import ru.vladimir.south_park.data.network.response.charceters.CharacterResponse
import ru.vladimir.south_park.data.network.response.charceters.CharactersResponseModel

interface SouthParkApi {

    @GET("characters/")
    suspend fun getCharacters(): CharactersResponseModel

//    ToDo Создать модель ответа сервер (не список)
    @GET("characters/1")
    suspend fun getCharacterOverview(): CharacterResponse
}
