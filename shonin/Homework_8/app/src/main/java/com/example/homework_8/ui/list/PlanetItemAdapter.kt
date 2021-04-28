package com.example.homework_8.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_8.databinding.ListItemBinding
import com.example.homework_8.ui.model.Planet

class PlanetItemAdapter(private val goo: (item: Planet) -> Unit) :
    ListAdapter<Planet, PlanetItemAdapter.ViewHolder>(
        DiffCallback
    ) {

    inner class ViewHolder(
        private val view: ListItemBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Planet) {
            view.textView.text = "${item.name}(${item.diameter})"
            view.textView2.text = item.population
            view.root.setOnClickListener {
                goo(item)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    object DiffCallback : DiffUtil.ItemCallback<Planet>() {
        override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Planet,
            newItem: Planet
        ): Boolean {
            return oldItem == newItem
        }
    }


}