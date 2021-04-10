package com.example.homework_fragment_6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_fragment_6.data.DataListTile
import com.example.homework_fragment_6.databinding.ItemRecyclerViewFirstBinding
import com.example.homework_fragment_6.databinding.ItemRecyclerViewTwoBinding

class AdapterListTile : ListAdapter<DataListTile, RecyclerView.ViewHolder>(DataCallback()) {

    class ViewHolderTileFirst(private val binding: ItemRecyclerViewFirstBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tile: DataListTile) {
            binding.textViewTitleTile.text = tile.title
            binding.textViewWarning.text = tile.textWarning
            binding.textViewId.text = tile.id
            binding.imageViewMain.setImageDrawable(tile.image)
        }
    }

    class ViewHolderTileSecond(private val binding: ItemRecyclerViewTwoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tile: DataListTile) {
            binding.textViewTitleTileTwo.text = tile.title
            binding.textViewInfoDate.text = tile.textInfo
            binding.textViewIdTwo.text = tile.id
            binding.imageViewMainTwo.setImageDrawable(tile.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 1) {
            val binding = ItemRecyclerViewTwoBinding.inflate(layoutInflater, parent, false)
            ViewHolderTileSecond(binding)
        } else {
            val binding = ItemRecyclerViewFirstBinding.inflate(layoutInflater, parent, false)
            ViewHolderTileFirst(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            (holder as ViewHolderTileSecond).bind(currentList[position])
        } else
            (holder as ViewHolderTileFirst).bind(currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0 until 2 -> 0
            else -> 1
        }
    }

}

class DataCallback : DiffUtil.ItemCallback<DataListTile>() {
    override fun areItemsTheSame(oldItem: DataListTile, newItem: DataListTile): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataListTile, newItem: DataListTile): Boolean {
        return oldItem == newItem
    }

}