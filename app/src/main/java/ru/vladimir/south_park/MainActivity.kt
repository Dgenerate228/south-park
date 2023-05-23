package ru.vladimir.south_park

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.vladimir.south_park.common.data.observe

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testTv: TextView = findViewById(R.id.test_tv)


        viewModel.charactersState.observe(this) { characters ->
            val text = StringBuilder("")
            characters.forEach { characterModel ->
                text.append(
                    "id: ${characterModel.id}\n" +
                            "name: ${characterModel.name}\n" +
                            "age: ${characterModel.age}\n" +
                            "sex: ${characterModel.sex}\n\n"
                )

            }
            if(characters.isEmpty()) testTv.text = "Loading..." else testTv.text = text.toString()
        }
    }
}