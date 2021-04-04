package com.example.homework5.ui.adapters.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ext.toDp

class ServiceListDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        val currentPosition = parent.getChildAdapterPosition(view).let {
            if (it == RecyclerView.NO_POSITION) return else it
        }
        when (currentPosition) {
            0 -> {
                outRect.top = 8.toDp()
                outRect.bottom = 4.toDp()
            }
            1 -> {
                outRect.top = 4.toDp()
            }
            parent.adapter!!.itemCount - 1 -> {
                outRect.top = 10.toDp()
                outRect.bottom = 20.toDp()
            }
            else -> {
                outRect.top = 10.toDp()
                outRect.bottom = 10.toDp()
            }
        }

        if (currentPosition > 0) {
            outRect.right = 8.toDp()
            outRect.left = 8.toDp()
        }
    }
}