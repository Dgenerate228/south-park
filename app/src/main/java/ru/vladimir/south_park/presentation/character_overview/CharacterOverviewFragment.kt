package ru.vladimir.south_park.presentation.character_overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ru.vladimir.south_park.R
import ru.vladimir.south_park.databinding.FragmentCharacterOverviewBinding

class CharacterOverviewFragment : Fragment(R.layout.fragment_character_overview) {

    private lateinit var binding: FragmentCharacterOverviewBinding

    private val args by navArgs<CharacterOverviewFragmentArgs>()
    private val characterId by lazy { args.characterId }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterOverviewBinding.bind(view)

        val text = "${binding.characterOverviewTestTv.text}: $characterId"
        binding.characterOverviewTestTv.text = text
    }

    // ToDo По аналогии с HomeFragment создать ViewModel
    // ToDO И подписаться на state(источник данных)
}
