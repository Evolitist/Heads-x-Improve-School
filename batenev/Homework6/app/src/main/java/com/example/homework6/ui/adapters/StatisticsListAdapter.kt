package com.example.homework6.ui.adapters


import android.content.Context
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework6.ui.common.StatisticsItemView
import data.MeasurementData


class StatisticsListAdapter :
    ListAdapter<MeasurementData, StatisticsListAdapter.StatisticsViewHolder>(DiffUtilCallback) {

    private lateinit var parentContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticsViewHolder {
        val view = StatisticsItemView(parent.context)
        view.apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        return StatisticsViewHolder(view)
    }


    override fun onBindViewHolder(holder: StatisticsViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<MeasurementData>() {
        override fun areItemsTheSame(
            oldItem: MeasurementData,
            newItem: MeasurementData
        ): Boolean {
            return oldItem.serialNumber == newItem.serialNumber
        }

        override fun areContentsTheSame(
            oldItem: MeasurementData,
            newItem: MeasurementData
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        parentContext = recyclerView.context
        super.onAttachedToRecyclerView(recyclerView)
    }

    inner class StatisticsViewHolder(
        private val view: StatisticsItemView
    ) : RecyclerView.ViewHolder(view) {
        fun bind(item: MeasurementData) {
            view.title = item.title
            view.inputType = item.inputType
            view.measurementInfo = item.measurementInfo
            view.serialNumber = item.serialNumber
            view.icon = ContextCompat.getDrawable(parentContext, item.iconResId)
        }
    }

}