package com.example.homework7.ui.starships.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.databinding.ListItemBinding
import com.example.homework7.ui.starships.model.StarshipUiModel

class StarshipsListAdapter(
    private val onItemClick: (item: StarshipUiModel) -> Unit
) : ListAdapter<StarshipUiModel, StarshipsListAdapter.StarshipsViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipsViewHolder {
        return StarshipsViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StarshipsViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class StarshipsViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StarshipUiModel) {
            binding.apply {
                title.text = item.name
                root.setOnClickListener {
                    onItemClick.invoke(item)
                }
            }
        }
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<StarshipUiModel>() {
        override fun areItemsTheSame(
            oldItem: StarshipUiModel,
            newItem: StarshipUiModel
        ): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(
            oldItem: StarshipUiModel,
            newItem: StarshipUiModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}