package ru.vladimir.south_park.presentation.character_overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.vladimir.south_park.databinding.ItemCharacterBinding
import ru.vladimir.south_park.domain.model.CharacterModel
import ru.vladimir.south_park.domain.model.CharacterOverviewModel

class CharacterOverviewAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)

        val age = character.age?.toString() ?: "-"

        with(holder.binding) {
            itemCharacterNameTv.text = character.name
            itemCharacterAgeTv.text = age
            itemCharacterSexTv.text = character.sex
        }
    }

    inner class ViewHolder(internal val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class CharactersDiffUtil : DiffUtil.ItemCallback<CharacterOverviewModel>() {

    override fun areItemsTheSame(
        oldItem: CharacterOverviewModel,
        newItem: CharacterOverviewModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: CharacterOverviewModel,
        newItem: CharacterOverviewModel
    ): Boolean = oldItem == newItem
}
}