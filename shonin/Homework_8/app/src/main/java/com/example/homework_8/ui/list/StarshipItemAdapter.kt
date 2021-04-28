package com.example.homework_8.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_8.databinding.ListItemBinding
import com.example.homework_8.ui.model.Starship

class StarshipItemAdapter(private val goo: (item: Starship) -> Unit) :
    ListAdapter<Starship, StarshipItemAdapter.ViewHolder>(
        DiffCallback
    ) {

    inner class ViewHolder(
        private val view: ListItemBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Starship) {
            view.textView.text = "${item.name}(${item.model})"
            view.textView2.text = item.manufacturer
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

    object DiffCallback : DiffUtil.ItemCallback<Starship>() {
        override fun areItemsTheSame(oldItem: Starship, newItem: Starship): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Starship,
            newItem: Starship
        ): Boolean {
            return oldItem == newItem
        }
    }


}