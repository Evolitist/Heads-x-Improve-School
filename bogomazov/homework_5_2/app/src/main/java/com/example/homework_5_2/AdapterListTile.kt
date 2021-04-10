package com.example.homework_5_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_5_2.databinding.StoreTileBinding

class AdapterListTile : ListAdapter<ListTileData, AdapterListTile.ViewHolderTile>(DataCallback()) {

    class ViewHolderTile(private val binding: StoreTileBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tile: ListTileData) {
            binding.title.text = tile.title
            binding.nameTile.text = tile.nameTile
            binding.subtitle.text = tile.subtitle
            binding.imageView.setImageDrawable(tile.image)
        }

        fun toggleVisibleLike() {
            binding.imageLike.isVisible = !binding.imageLike.isVisible
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTile {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StoreTileBinding.inflate(layoutInflater, parent, false)
        return ViewHolderTile(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderTile, position: Int) {
        holder.bind(currentList[position])
        holder.itemView.setOnClickListener {
            holder.toggleVisibleLike()
        }
    }

}

class DataCallback : DiffUtil.ItemCallback<ListTileData>() {
    override fun areItemsTheSame(oldItem: ListTileData, newItem: ListTileData): Boolean {
        return oldItem.nameTile == newItem.nameTile
    }

    override fun areContentsTheSame(oldItem: ListTileData, newItem: ListTileData): Boolean {
        return oldItem == newItem
    }

}