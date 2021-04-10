package com.example.homework_5_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_5_2.databinding.ListTileHeaderServicesBinding
import com.example.homework_5_2.databinding.ListTileHeaderMainBinding

class AdapterHeader() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class ViewHolderHeaderTitle(binding: ListTileHeaderMainBinding) : RecyclerView.ViewHolder(binding.root)
    class ViewHolderServices(binding: ListTileHeaderServicesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 0) {
            val binding = ListTileHeaderServicesBinding.inflate(layoutInflater, parent, false)
            ViewHolderServices(binding)
        } else {
            val binding = ListTileHeaderMainBinding.inflate(layoutInflater, parent, false)
            ViewHolderHeaderTitle(binding)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 1) 1 else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == 0) {
            holder as ViewHolderServices
        } else
            holder as ViewHolderHeaderTitle
    }

    override fun getItemCount() = ITEM_POSITION_SIZE

    companion object {
        private const val ITEM_POSITION_SIZE = 2
    }

}
