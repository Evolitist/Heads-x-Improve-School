package com.example.task8.ui.main.adapter

import com.example.task8.databinding.SmallPlanetItemBinding
import com.example.task8.network.planets.PlanetApiModel
import com.example.task8.ui.main.models.Planet

class PlanetViewHolder(
    private val binding: SmallPlanetItemBinding,
) : AbstractAdapter.ViewHolder<Planet>(binding) {

    override fun bind(data: Planet, onClick: (Planet) -> Unit) {
        binding.name.text = data.name
        binding.climate.text = data.climate
        binding.root.setOnClickListener {
            onClick(data)
        }
    }
}