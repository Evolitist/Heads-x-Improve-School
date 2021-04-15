package com.example.task8.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.databinding.SmallFilmItemBinding
import com.example.task8.network.StarShips.StarShipApiModel
import com.example.task8.network.films.FilmApiModel

class SmallFilmsAdapter(
    private val itemListener: (FilmApiModel) -> Unit
): ListAdapter<FilmApiModel, SmallFilmsAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            SmallFilmItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        itemListener,
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(
        private val binding: SmallFilmItemBinding,
        private val listener: (FilmApiModel) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: FilmApiModel){
            binding.title.text = item.title
            binding.episode.text = item.episodeId.toString()
            if (item != null){
                binding.root.setOnClickListener{
                    listener(item)
                }
            } else {
                binding.root.setOnClickListener(null)
            }
        }
    }

    object DiffCallback: DiffUtil.ItemCallback<FilmApiModel>() {
        override fun areItemsTheSame(oldItem: FilmApiModel, newItem: FilmApiModel): Boolean
                = oldItem.title ==newItem.title

        override fun areContentsTheSame(oldItem: FilmApiModel, newItem:FilmApiModel): Boolean = oldItem == newItem
    }
}
