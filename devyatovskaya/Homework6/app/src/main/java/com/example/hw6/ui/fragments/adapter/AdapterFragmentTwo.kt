package com.example.hw6.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6.databinding.ListTile2Binding
import com.example.hw6.databinding.ListTileBinding

class AdapterFragmentTwo :
    ListAdapter<PlaceholderItem, RecyclerView.ViewHolder>(DiffUtilCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_ONE) {
            return ViewHolder(
                ListTileBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
        return ViewHolder2(
            ListTile2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (currentList[position].type == VIEW_ONE) {
            (holder as ViewHolder).bind(currentList[position])
        } else {
            (holder as ViewHolder2).bind(currentList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].type
    }

    class ViewHolder(
        private val binding: ListTileBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: PlaceholderItem){
            with(binding){
                textWater.text = item.title
                imageWater.setImageDrawable(item.image)
                textGiveData.text = item.subtext
            }
        }
    }

    class ViewHolder2(
        private val binding: ListTile2Binding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: PlaceholderItem){
            with(binding){
                textElectricity.text = item.title
                imageElectricity.setImageDrawable(item.image)
                textView.text = item.subtext
            }
        }
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<PlaceholderItem>() {
        override fun areItemsTheSame(
            oldItem: PlaceholderItem,
            newItem: PlaceholderItem
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: PlaceholderItem,
            newItem: PlaceholderItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    companion object{
        const val VIEW_ONE = 1
        const val VIEW_TWO = 2
    }

}