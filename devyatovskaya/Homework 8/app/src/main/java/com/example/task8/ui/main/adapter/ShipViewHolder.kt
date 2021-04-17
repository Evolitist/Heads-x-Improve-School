package com.example.task8.ui.main.adapter

import com.example.task8.databinding.SmallShipItemBinding
import com.example.task8.ui.main.models.Starship


class ShipViewHolder(
    private val binding: SmallShipItemBinding,
) : AbstractAdapter.ViewHolder<Starship>(binding) {

    override fun bind(data: Starship, onClick: (Starship) -> Unit) {
        binding.name.text = data.name
        binding.model.text = data.model
        binding.root.setOnClickListener {
            onClick(data)
        }
    }
}