package com.example.homework_6

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_6.databinding.ListTileeBinding

data class PlaceholderItem(
    val id: String,
    val serialNumber: Int,
    val title: String,
    val subtitle1: String,
    val subtitle2: String?,
    val subtitle3: String?,
    val image: Drawable?,
    val alert: String,
    val showAlert: Int?
) {
    override fun toString(): String = title
}


class ItemAdapter(private val context: Context, private var list: ArrayList<PlaceholderItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(
        private val view: ListTileeBinding
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: PlaceholderItem) {
            view.listview.title = item.title
            view.listview.image1 = item.image
            view.listview.subtitle1 = item.subtitle1
            view.listview.subtitle2 = item.subtitle2
            view.listview.subtitle3 = item.subtitle3
            view.listview.serialNumber = item.serialNumber.toString()
            view.listview.alert = item.alert
            view.listview.imageAlert = item.showAlert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ListTileeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}