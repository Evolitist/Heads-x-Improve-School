package com.example.lesson_4

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_4.databinding.ListTilee2Binding
import com.example.homework_4.databinding.ListTileeBinding
import com.google.android.material.snackbar.Snackbar


data class PlaceholderItem(
    val id: String,
    val title: String,
    val subtitle: String?,
    val image: Drawable?,
    val color: Int?,
    val type: Int
) {
    override fun toString(): String = title
}


class ItemAdapter(private val context: Context, private var list: ArrayList<PlaceholderItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ONE = 1
    private val VIEW_TYPE_TWO = 2

    inner class ViewHolder(
        private val view: ListTileeBinding
    ) : RecyclerView.ViewHolder(view.root){
        fun bind(item: PlaceholderItem) {
            view.listview.title = item.title
            view.listview.leading = item.image
            view.listview.subtitle = item.subtitle
            view.root.setOnClickListener{ itemClick(view.root, view.listview.title) }
        }

    }

    fun itemClick(view: View, s: CharSequence) {
        Snackbar.make(view, s, Snackbar.LENGTH_SHORT).show();
    }

    inner class ViewHolder2(
        private val view: ListTilee2Binding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: PlaceholderItem)  {
            view.listview.title = item.title
            view.listview.leading = item.image
            view.listview.subtitle = item.subtitle
            view.listview.color = item.color
            view.root.setOnClickListener{ itemClick(view.root, view.listview.title) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            ViewHolder(ListTileeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            ViewHolder2(
                ListTilee2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (list[position].type == 1) {
            (holder as ViewHolder).bind(list[position])
        } else {
            (holder as ViewHolder2).bind(list[position])
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position].type == 1) {
            VIEW_TYPE_ONE
        } else VIEW_TYPE_TWO
    }

}