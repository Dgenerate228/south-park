package ru.vladimir.south_park.presentation.episodes_overview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.vladimir.south_park.databinding.ItemEpisodesOverviewBinding
import ru.vladimir.south_park.domain.model.EpisodesOverviewModel

class EpisodesOverviewAdapter: ListAdapter<EpisodesOverviewModel, EpisodesOverviewAdapter.ViewHolder>(
    EpisodesOverviewDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodesOverviewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episodes = getItem(position)
        with(holder.binding) {
            seasonGet.text = episodes.name
            episodeGet.text = episodes.episode.toString()
            nameText.text = episodes.season.toString()
        }
    }

    inner class ViewHolder(internal val binding: ItemEpisodesOverviewBinding) :
        RecyclerView.ViewHolder(binding.root)

}
    class EpisodesOverviewDiffUtil : DiffUtil.ItemCallback<EpisodesOverviewModel>() {

        override fun areItemsTheSame(
            oldItem: EpisodesOverviewModel,
            newItem: EpisodesOverviewModel,
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: EpisodesOverviewModel,
            newItem: EpisodesOverviewModel,
        ): Boolean = oldItem == newItem
    }
