package com.example.task8.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.databinding.SmallPlanetItemBinding
import com.example.task8.network.Planets.PlanetApiModel

class SmallPlanetAdapter(
    private val itemListener: (PlanetApiModel) -> Unit
): ListAdapter<PlanetApiModel, SmallPlanetAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            SmallPlanetItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        itemListener
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class ViewHolder(
        private val binding: SmallPlanetItemBinding,
        private val listener: (PlanetApiModel) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: PlanetApiModel){
            binding.name.text = item.name
            binding.climate.text = item.climate
            if (item != null){
                binding.root.setOnClickListener{
                    listener(item)
                }
            } else {
                binding.root.setOnClickListener(null)
            }
        }
    }

    object DiffCallback: DiffUtil.ItemCallback<PlanetApiModel>() {
        override fun areItemsTheSame(oldItem: PlanetApiModel, newItem: PlanetApiModel): Boolean
                = oldItem.name ==newItem.name

        override fun areContentsTheSame(oldItem: PlanetApiModel, newItem:PlanetApiModel): Boolean = oldItem == newItem
    }
}
