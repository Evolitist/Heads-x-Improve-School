package com.evolitist.swapi.ui.list

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.evolitist.swapi.databinding.ListItemBinding
import com.evolitist.swapi.ui.inflater
import com.evolitist.swapi.ui.model.Person

class ListItemAdapter(
    private val itemClickCallback: (Person) -> Unit,
) : PagingDataAdapter<Person, ListItemAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ) = ViewHolder(
        ListItemBinding.inflate(parent.inflater, parent, false),
        itemClickCallback, //doesn't change from item to item so it's safe to pass it here
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)) //getItem may return null in case placeholder is needed
    }

    class ViewHolder(
        private val binding: ListItemBinding,
        private val clickCallback: (Person) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Person?) {
            binding.title.text = item?.name
            if (item != null) {
                binding.root.setOnClickListener {
                    clickCallback(item)
                }
            } else {
                binding.root.setOnClickListener(null)
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(
            oldItem: Person,
            newItem: Person,
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Person,
            newItem: Person,
        ) = oldItem == newItem
    }
}
