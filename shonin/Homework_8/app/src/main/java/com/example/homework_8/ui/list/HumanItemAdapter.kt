package com.example.homework_8.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_8.databinding.ListItemBinding
import com.example.homework_8.ui.model.Human

class HumanItemAdapter(private val goo: (item: Human) -> Unit) :
    ListAdapter<Human, HumanItemAdapter.ViewHolder>(
        DiffCallback
    ) {

    inner class ViewHolder(
        private val view: ListItemBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: Human) {
            view.textView.text = "${item.name}(${item.birthYear})"
            view.textView2.text = item.gender
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

    object DiffCallback : DiffUtil.ItemCallback<Human>() {
        override fun areItemsTheSame(oldItem: Human, newItem: Human): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Human,
            newItem: Human
        ): Boolean {
            return oldItem == newItem
        }
    }

}