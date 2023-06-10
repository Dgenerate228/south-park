package ru.vladimir.south_park.presentation.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.vladimir.south_park.databinding.ItemEpisodesBinding
import ru.vladimir.south_park.domain.model.EpisodesModel

class EpisodesAdapter: ListAdapter<EpisodesModel, EpisodesAdapter.ViewHolder>(
    EpisodesDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episodes = getItem(position)
        with(holder.binding) {
            episodeTextGet.text = episodes.episode.toString()
            seasonTextGet.text = episodes.season.toString()
            urlGet.text = episodes.wikiUrl
        }
    }

    inner class ViewHolder(internal val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root)
}

class EpisodesDiffUtil : DiffUtil.ItemCallback<EpisodesModel>() {

    override fun areItemsTheSame(
        oldItem: EpisodesModel,
        newItem: EpisodesModel,
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: EpisodesModel,
        newItem: EpisodesModel,
    ): Boolean = oldItem == newItem
}
