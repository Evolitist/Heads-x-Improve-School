package com.example.homework_8_retrofit_swapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_8_retrofit_swapi.databinding.ListTileRecyclerPlanetsBinding
import com.example.homework_8_retrofit_swapi.db.entities.DBModelPlanets
import com.example.homework_8_retrofit_swapi.ui.OnClickCardRecycler


class AdapterRecyclerViewPlanets(private val onClickTilePlanets: OnClickCardRecycler<DBModelPlanets>) :
    ListAdapter<DBModelPlanets, AdapterRecyclerViewPlanets.CustomViewHolder>(DataCallBackPlanet()) {

    class CustomViewHolder(private val binding: ListTileRecyclerPlanetsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemTile = binding.listTileCardRecyclerPlanets

        fun bind(planet: DBModelPlanets) {
            binding.textViewTilePlanetName.text = planet.name
            binding.textViewTileClimatePlanets.text = planet.climate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListTileRecyclerPlanetsBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.itemTile.setOnClickListener {
            onClickTilePlanets.openNewFragment(currentList[position])
        }
    }
}

class DataCallBackPlanet : DiffUtil.ItemCallback<DBModelPlanets>() {
    override fun areItemsTheSame(oldItem: DBModelPlanets, newItem: DBModelPlanets): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DBModelPlanets, newItem: DBModelPlanets): Boolean {
        return oldItem == newItem
    }

}