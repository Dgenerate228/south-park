package ru.vladimir.south_park.data.network.repository

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vladimir.south_park.data.network.api.SouthParkApi
import ru.vladimir.south_park.domain.model.CharacterModel
import ru.vladimir.south_park.domain.model.CharacterOverviewModel
import ru.vladimir.south_park.domain.model.EpisodesModel
import ru.vladimir.south_park.domain.model.RelativeModel

class SouseParkRepository {
    private val gson = GsonBuilder().setLenient().create()
    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder().baseUrl("https://spapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient).build()
    private val southParkApi = retrofit.create(SouthParkApi::class.java)

    suspend fun getCharacters(): List<CharacterModel> = withContext(Dispatchers.IO) {
        southParkApi.getCharacters().characters.map { characterResponse ->
            CharacterModel(
                id = characterResponse.id.toString(),
                name = characterResponse.name,
                age = characterResponse.age,
                sex = characterResponse.sex
            )
        }
    }

    suspend fun getCharacterOverview(): CharacterOverviewModel = withContext(Dispatchers.IO) {
        val characterResponse = southParkApi.getCharactersOverview().data
        CharacterOverviewModel(id = characterResponse.id,
            age = characterResponse.age,
            name = characterResponse.name,
            sex = characterResponse.sex,
            religion = characterResponse.religion,
            occupation = characterResponse.occupation,
            voicedBy = characterResponse.voiced,
            hairColor = characterResponse.hairColor,
            episodes = characterResponse.episodes,
            relatives = characterResponse.relatives.map { RelativeModel(it.url, it.relation) })
    }

    suspend fun getEpisodes(): EpisodesModel = withContext(Dispatchers.IO) {
        val episodesResponse = southParkApi.getEpisodes().episodes
        EpisodesModel(
            id = episodesResponse.id,
            name = episodesResponse.name,
            season = episodesResponse.season,
            episode = episodesResponse.episode,
            airDate = episodesResponse.airDate,
            wikiUrl = episodesResponse.wikiUrl,
            thumbnailUrl = episodesResponse.thumbnailUrl,
            description = episodesResponse.description,
            createdAt = episodesResponse.createdAt,
            updatedAt = episodesResponse.updatedAt,
            characters = episodesResponse.characters
        )
    }
}
