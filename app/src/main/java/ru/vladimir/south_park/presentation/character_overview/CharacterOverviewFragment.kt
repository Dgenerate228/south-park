package ru.vladimir.south_park.presentation.character_overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import ru.vladimir.south_park.R
import ru.vladimir.south_park.common.data.observe
import ru.vladimir.south_park.databinding.FragmentCharacterOverviewBinding
import ru.vladimir.south_park.presentation.home.CharactersAdapter
import ru.vladimir.south_park.presentation.home.HomeViewModel


class CharacterOverviewFragment : Fragment(R.layout.fragment_character_overview) {

    private lateinit var binding: FragmentCharacterOverviewBinding

    private val viewModel: CharacterOverviewViewModel by viewModels()

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

    private fun observeViewModel() {
        viewModel.charactersState.observe(this) { characters ->
            /**
             * Действия при изменении источника данных
             * Изенение данных в [CharactersAdapter]
             */
            CharacterOverviewAdapter.submitList(characters)
        }
    }
}
