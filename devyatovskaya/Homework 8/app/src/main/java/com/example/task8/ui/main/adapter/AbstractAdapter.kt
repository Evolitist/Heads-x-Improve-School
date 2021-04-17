package com.example.task8.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class AbstractAdapter<T, VH : AbstractAdapter.ViewHolder<T>>(
    private val createViewHolder: (LayoutInflater, ViewGroup) -> VH,
    private val clickCallback: (T) -> Unit,
) : ListAdapter<T, VH>(DiffCallback<T>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolder(LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.also { holder.bind(it, clickCallback) }
    }

    class DiffCallback<T> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
    }

    abstract class ViewHolder<T>(
        binding: ViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(data: T, onClick: (T) -> Unit)
    }
}
