package com.example.homework_recview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_recview.data.DataClassGrid
import com.example.homework_recview.databinding.ListTileGridBinding
import com.example.homework_recview.databinding.ListTileGridLastBinding

class GridRecAdapter(private val listGridSize: Int, private val onClick: OnClick) : ListAdapter<DataClassGrid, RecyclerView.ViewHolder>(DataCallbackGrid()) {


    class ViewHolderGrid(private val binding: ListTileGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataClassGrid) {
            binding.titleGrid.text = item.title
            binding.subtitleGrid.text = item.subtitle
            binding.imageViewGrid.setImageDrawable(item.images)
            if (item.warning)
                binding.subtitleGrid.setTextColor(ContextCompat.getColor(binding.root.context, R.color.warning))
        }
    }

    class ViewHolderGridLast(private val binding: ListTileGridLastBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataClassGrid) {
            binding.titleGridLast.text = item.title
            binding.subtitleGridLast.text = item.subtitle
            binding.imageView.setImageDrawable(item.images)
            if (item.warning)
                binding.subtitleGridLast.setTextColor(ContextCompat.getColor(binding.root.context, R.color.warning))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 1) {
            val binding = ListTileGridBinding.inflate(layoutInflater, parent, false)
            ViewHolderGrid(binding)
        } else {
            val binding = ListTileGridLastBinding.inflate(layoutInflater, parent, false)
            ViewHolderGridLast(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0 until listGridSize -> 1
            else -> 0
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 1) {
            (holder as ViewHolderGrid).bind(currentList[position])
        } else
            (holder as ViewHolderGridLast).bind(currentList[position])

        holder.itemView.setOnClickListener { onClick.onClickItem(currentList[position].title) }
    }
}

class DataCallbackGrid : DiffUtil.ItemCallback<DataClassGrid>() {
    override fun areItemsTheSame(oldItem: DataClassGrid, newItem: DataClassGrid): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DataClassGrid, newItem: DataClassGrid): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}