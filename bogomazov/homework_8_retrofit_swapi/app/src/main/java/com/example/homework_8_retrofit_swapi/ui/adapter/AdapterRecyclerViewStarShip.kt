package com.example.homework_8_retrofit_swapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_8_retrofit_swapi.databinding.ListTileRecyclerStarshipsBinding
import com.example.homework_8_retrofit_swapi.db.entities.DBModelStarship
import com.example.homework_8_retrofit_swapi.ui.OnClickCardRecycler

class AdapterRecyclerViewStarship(private val onClickTileStarship: OnClickCardRecycler<DBModelStarship>) :
    ListAdapter<DBModelStarship, AdapterRecyclerViewStarship.CustomViewHolder>(
        DataCallBack()
    ) {
    class CustomViewHolder(private val binding: ListTileRecyclerStarshipsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val item = binding.listTileCardRecyclerStarship
        fun bind(item: DBModelStarship) {
            binding.textViewTileStarshipModel.text = item.model
            binding.textViewTileStarshipName.text = item.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListTileRecyclerStarshipsBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(currentList[position])
        holder.item.setOnClickListener {
            onClickTileStarship.openNewFragment(currentList[position])
        }
    }
}

class DataCallBack : DiffUtil.ItemCallback<DBModelStarship>() {
    override fun areItemsTheSame(oldItem: DBModelStarship, newItem: DBModelStarship): Boolean {
        return oldItem.model == newItem.model
    }

    override fun areContentsTheSame(oldItem: DBModelStarship, newItem: DBModelStarship): Boolean {
        return oldItem == newItem
    }

}