package com.evolitist.lesson1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.evolitist.lesson1.databinding.ListItemBinding
import com.evolitist.lesson1.placeholder.PlaceholderContent.ListItem

class ItemAdapter : ListAdapter<ListItem, ItemAdapter.ItemViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            viewType == 0
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0, 1, 2, 3, 4, 5 -> 1
            else -> 0
        }
    }

    class ItemViewHolder(
        private val binding: ListItemBinding,
        private val hasImage: Boolean,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListItem) {
            binding.tile.leading = if (hasImage) item.image else null
            binding.tile.title = item.title
            binding.tile.subtitle = item.subtitle
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(
            oldItem: ListItem,
            newItem: ListItem,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ListItem,
            newItem: ListItem,
        ) = oldItem == newItem
    }
}
