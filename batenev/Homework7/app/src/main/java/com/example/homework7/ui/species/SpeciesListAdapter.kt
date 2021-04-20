package com.example.homework7.ui.species

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.databinding.ListItemBinding
import com.example.homework7.network.model.species.SpeciesApiModel
import com.example.homework7.ui.species.model.SpeciesUiModel

class SpeciesListAdapter(

) : ListAdapter<SpeciesUiModel, SpeciesListAdapter.SpeciesViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        return SpeciesViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class SpeciesViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SpeciesUiModel) {
            binding.title.text = item.name
        }
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<SpeciesUiModel>() {
        override fun areItemsTheSame(oldItem: SpeciesUiModel, newItem: SpeciesUiModel): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(oldItem: SpeciesUiModel, newItem: SpeciesUiModel): Boolean {
            return oldItem == newItem
        }
    }
}