package com.example.task8.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task8.databinding.SmallShipItemBinding
import com.example.task8.network.StarShips.StarShipApiModel

class SmallShipAdapter(
     private val itemListener: (StarShipApiModel) -> Unit
) : ListAdapter<StarShipApiModel, SmallShipAdapter.ViewHolder>(DiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    =  ViewHolder(
            SmallShipItemBinding.inflate(
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
            private val binding: SmallShipItemBinding,
            val listener: (StarShipApiModel) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: StarShipApiModel) {
            binding.name.text = item.name
            binding.model.text = item.model
            if (item != null){
                binding.root.setOnClickListener{
                    listener(item)
                }
            } else {
                binding.root.setOnClickListener(null)
            }
        }
    }

    object DiffCallback: DiffUtil.ItemCallback<StarShipApiModel>() {
        override fun areItemsTheSame(oldItem: StarShipApiModel, newItem: StarShipApiModel): Boolean
            = oldItem.name==newItem.name

        override fun areContentsTheSame(oldItem: StarShipApiModel, newItem: StarShipApiModel): Boolean = oldItem == newItem
    }
}