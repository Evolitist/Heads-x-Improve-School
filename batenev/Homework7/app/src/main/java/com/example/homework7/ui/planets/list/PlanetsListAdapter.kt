package com.example.homework7.ui.planets.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework7.databinding.ListItemBinding
import com.example.homework7.ui.planets.model.PlanetUiModel

class PlanetsListAdapter(
    private val onItemClick: (item: PlanetUiModel) -> Unit
) : ListAdapter<PlanetUiModel, PlanetsListAdapter.PlanetViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        return PlanetViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class PlanetViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlanetUiModel) {
            binding.apply {
                title.text = item.name
                root.setOnClickListener {
                    onItemClick.invoke(item)
                }
            }
        }
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<PlanetUiModel>() {
        override fun areItemsTheSame(oldItem: PlanetUiModel, newItem: PlanetUiModel): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(oldItem: PlanetUiModel, newItem: PlanetUiModel): Boolean {
            return oldItem == newItem
        }
    }
}