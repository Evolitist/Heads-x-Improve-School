package com.example.lesson_4

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_5_2.databinding.ListTilee1Binding
import com.example.homework_5_2.databinding.ListTilee2Binding
import com.example.homework_5_2.databinding.ListTilee3Binding


data class PlaceholderItem(
    val id: String,
    val title: String,
    val subtitle: String?,
    val adress: String?,
    val image: Drawable?,
    val type: Int
) {
    override fun toString(): String = title
}


class ItemAdapter(private val context: Context, private var list: ArrayList<PlaceholderItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
    }

    inner class ViewHolder1(
        private val view: ListTilee1Binding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: PlaceholderItem) {
            view.listview.title = item.title
        }

    }

    inner class ViewHolder2(
        private val view: ListTilee2Binding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: PlaceholderItem) {
            view.listview.title = item.title
            view.listview.image = item.image
        }
    }

    inner class ViewHolder3(
        private val view: ListTilee3Binding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: PlaceholderItem) {
            view.listview.title = item.title
            view.listview.subtitle = item.subtitle
            view.listview.adress = item.adress
            view.listview.image = item.image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ONE -> ViewHolder1(
                ListTilee1Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            VIEW_TYPE_TWO -> ViewHolder2(
                ListTilee2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> ViewHolder3(
                ListTilee3Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].type) {
            VIEW_TYPE_ONE -> (holder as ViewHolder1).bind(list[position])
            VIEW_TYPE_TWO -> (holder as ViewHolder2).bind(list[position])
            else -> (holder as ViewHolder3).bind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            VIEW_TYPE_ONE -> VIEW_TYPE_ONE
            VIEW_TYPE_TWO -> VIEW_TYPE_TWO
            else -> VIEW_TYPE_THREE
        }
    }
}