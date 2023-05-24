package ru.vladimir.south_park.presentation.character_overview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.vladimir.south_park.R
import ru.vladimir.south_park.common.data.observe
import ru.vladimir.south_park.databinding.FragmentCharacterOverviewBinding

class CharacterOverviewFragment : Fragment(R.layout.fragment_character_overview) {

    private lateinit var binding: FragmentCharacterOverviewBinding

    private val viewModel: CharacterOverviewViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCharacterOverviewBinding.bind(view)
        observeViewModel()

        binding.idText.text
        binding.nameText.text
    }

    private fun observeViewModel() {
        viewModel.charactersState.observe(this) { characters ->
            binding.idText.text = characters.id.toString()
            binding.nameText.text = characters.name
            binding.ageText.text = characters.age.toString()
            binding.sexText.text = characters.sex
            binding.hairColorText.text = characters.hairColor
            binding.occupationText.text = characters.occupation
            binding.religionText.text = characters.religion
            binding.voicedByText.text= characters.voicedBy
            binding.relativesTextURL.text= characters.relatives.map{ it.url }.toString()
            binding.relativesTextRelation.text= characters.relatives.map{ it.relation }.toString()
            binding.episodesText.text = characters.episodes.map { it }.toString()
        }
    }
}
