package com.example.homework6.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework6.R
import com.example.homework6.ui.common.StatisticsItemView
import data.MeasurementData


class StatisticsListAdapter :
    ListAdapter<MeasurementData, StatisticsListAdapter.StatisticsViewHolder>(DiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StatisticsViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(
                R.layout.statistics_list_item,
                parent,
                false
            ) as StatisticsItemView
    )

    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<MeasurementData>() {
        override fun areItemsTheSame(
            oldItem: MeasurementData,
            newItem: MeasurementData
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(
            oldItem: MeasurementData,
            newItem: MeasurementData
        ): Boolean {
            TODO("Not yet implemented")
        }
    }

    inner class StatisticsViewHolder(
        private val view: StatisticsItemView
    ) : RecyclerView.ViewHolder(view) {
        fun bind(item: MeasurementData) {
            //TODO
        }
    }

}