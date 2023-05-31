package ru.vladimir.south_park.presentation.character_overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.vladimir.south_park.databinding.ItemEpisodesBinding

class EpisodesOverviewAdapter : ListAdapter<String, EpisodesOverviewAdapter.ViewHolder>(
    CharactersDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode = getItem(position)
        with(holder.binding) {
            urlGet.text = episode
        }
    }

    inner class ViewHolder(internal val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root)

    class CharactersDiffUtil : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(
            oldItem: String,
            newItem: String,
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String,
        ): Boolean = oldItem == newItem
    }
}