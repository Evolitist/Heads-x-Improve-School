package com.example.homework_recview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_recview.data.DataClassLinear

import com.example.homework_recview.databinding.ListTileBinding

class LinearRecAdapter(private val onClick: OnClick) : ListAdapter<DataClassLinear, LinearRecAdapter.ViewHolder>(DataCallback()) {

    class ViewHolder(private val binding: ListTileBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataClassLinear) {
            binding.titleListTile.text = item.title
            binding.imageListTile.setImageDrawable(item.images)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListTileBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.itemView.setOnClickListener { onClick.onClickItem(currentList[position].title) }
    }
}

class DataCallback : DiffUtil.ItemCallback<DataClassLinear>() {
    override fun areItemsTheSame(oldItem: DataClassLinear, newItem: DataClassLinear): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DataClassLinear, newItem: DataClassLinear): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}