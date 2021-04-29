package com.example.homework_8_retrofit_swapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_8_retrofit_swapi.databinding.ListTileRecyclerVehicleBinding
import com.example.homework_8_retrofit_swapi.db.entities.DBModelVehicles
import com.example.homework_8_retrofit_swapi.ui.OnClickCardRecycler

class AdapterRecyclerViewVehicles(private val onClickTileVehicles: OnClickCardRecycler<DBModelVehicles>) :
    ListAdapter<DBModelVehicles, AdapterRecyclerViewVehicles.CustomViewHolder>(DataCallBackVehicles()) {
    class CustomViewHolder(private val binding: ListTileRecyclerVehicleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemContainer = binding.listTileCardRecyclerVehicle
        fun bind(vehicles: DBModelVehicles) {
            binding.textViewTileModelVehicles.text = vehicles.model
            binding.textViewTileVehiclesClass.text = vehicles.vehicleClass
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListTileRecyclerVehicleBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.itemContainer.setOnClickListener {
            onClickTileVehicles.openNewFragment(currentList[position])
        }
    }
}

class DataCallBackVehicles : DiffUtil.ItemCallback<DBModelVehicles>() {
    override fun areItemsTheSame(oldItem: DBModelVehicles, newItem: DBModelVehicles): Boolean {
        return oldItem.model == newItem.model
    }

    override fun areContentsTheSame(oldItem: DBModelVehicles, newItem: DBModelVehicles): Boolean {
        return oldItem == newItem
    }

}