package ru.vladimir.south_park.data.network.repository

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vladimir.south_park.data.network.api.SouthParkApi
import ru.vladimir.south_park.domain.model.CharacterModel

class SouseParkRepository() {

    private val gson = GsonBuilder()
        .setLenient()
        .create()
    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://spapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
    private val southParkApi = retrofit.create(SouthParkApi::class.java)

    suspend fun getCharactersResponse(): List<CharacterModel> =
        withContext(Dispatchers.IO) {
            delay(3000L)

            southParkApi.getCharacters().characters.map { characterResponse ->
                CharacterModel(
                    id = characterResponse.id,
                    name = characterResponse.name,
                    age = characterResponse.age,
                    sex = characterResponse.sex
                )
            }
        }
}
