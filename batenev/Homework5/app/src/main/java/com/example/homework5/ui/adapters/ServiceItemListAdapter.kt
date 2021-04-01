package com.example.homework5.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework5.R
import com.example.homework5.databinding.ServicesListHeaderItemBinding
import com.example.homework5.databinding.ServicesListItemBinding
import com.example.homework5.databinding.ServicesServiceOfferItemBinding
import data.ServiceDiscount

class ServiceItemListAdapter :
    ListAdapter<ServiceDiscount, RecyclerView.ViewHolder>(DiffUtilCallback) {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.services_list_header_item -> {
                HeaderVH(
                    ServicesListHeaderItemBinding.inflate(LayoutInflater.from(parent.context))
                )
            }
            R.layout.services_service_offer_item -> {
                ServiceOfferVH(
                    ServicesServiceOfferItemBinding.inflate(LayoutInflater.from(parent.context))
                )
            }
            R.layout.services_list_item -> {
                ServiceListItemVH(
                    ServicesListItemBinding.inflate(LayoutInflater.from(parent.context))
                )
            }
            else -> error("Unsupported viewType!")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            0 -> (holder as HeaderVH).bind()
            1 -> (holder as ServiceOfferVH).bind()
            else -> (holder as ServiceListItemVH).bind(currentList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> R.layout.services_list_header_item
            1 -> R.layout.services_service_offer_item
            else -> R.layout.services_list_item
        }
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<ServiceDiscount>() {
        override fun areItemsTheSame(
            oldItem: ServiceDiscount,
            newItem: ServiceDiscount,
        ) = oldItem.id == newItem.id


        override fun areContentsTheSame(
            oldItem: ServiceDiscount,
            newItem: ServiceDiscount,
        ) = oldItem == newItem
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    /*
    По итогу ничего умней этой гадости не сообразил.
    */
    override fun submitList(list: MutableList<ServiceDiscount>?) {
        list?.addAll(0, listOf(ServiceDiscount.getEmpty(), ServiceDiscount.getEmpty()))
        super.submitList(list)
    }

    class HeaderVH(
        private val binding: ServicesListHeaderItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tvAll.setOnClickListener {
                //TODO
            }
        }
    }

    class ServiceOfferVH(
        private val binding: ServicesServiceOfferItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.root.setOnClickListener {
                //TODO
            }
        }
    }

    inner class ServiceListItemVH(
        private val binding: ServicesListItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServiceDiscount) {
            with(binding) {
                //Картиночек на зеплине не дали
                Glide.with(recyclerView.context).load(item.imageUrl).into(icon)
                title.text = item.title
                discountText.text = item.discountText
                addressText.text = item.addressText
            }
        }
    }
}