package ru.vladimir.south_park.presentation.character_overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.vladimir.south_park.databinding.ItemOverviewBinding
import ru.vladimir.south_park.domain.model.RelativeModel

class CharacterOverviewAdapter : ListAdapter<RelativeModel,
        CharacterOverviewAdapter.ViewHolder>(
    CharactersDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOverviewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)

        with(holder.binding) {
            urlGet.text = character.url
            relativeFamilyGet.text = character.relation
        }
    }

    inner class ViewHolder(internal val binding: ItemOverviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    class CharactersDiffUtil : DiffUtil.ItemCallback<RelativeModel>() {

        override fun areItemsTheSame(
            oldItem: RelativeModel,
            newItem: RelativeModel,
        ): Boolean = oldItem.url == newItem.url

        override fun areContentsTheSame(
            oldItem: RelativeModel,
            newItem: RelativeModel,
        ): Boolean = oldItem == newItem
    }
}