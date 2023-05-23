package ru.vladimir.south_park.data.network.repository

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vladimir.south_park.data.network.api.SouthParkApi
import ru.vladimir.south_park.domain.model.CharacterModel

class SouseParkRepository() {

    //    Создание инструментов для работы с сетью
    private val gson = GsonBuilder()
        .setLenient()
        .create()
    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://spapi.dev/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    //    Класс для запрос в сеть
    private val southParkApi = retrofit.create(SouthParkApi::class.java)

    suspend fun getCharacters(): List<CharacterModel> =
//        Меняем поток с UI(Поток для отрисовки экрана) на IO(Поток для запросв в сеть)
        withContext(Dispatchers.IO) {
//            Запрос в сеть и приведение к типу List<CharacterModel>
            southParkApi.getCharacters().characters.map { characterResponse ->
                CharacterModel(
                    id = characterResponse.id.toString(),
                    name = characterResponse.name,
                    age = characterResponse.age,
                    sex = characterResponse.sex
                )
            }
        }

    /**
     *     ToDo Метод для запроса деталей персонажа
     *     ToDo Создать В domain модель и вернуть ее в этом списке
     */
}
