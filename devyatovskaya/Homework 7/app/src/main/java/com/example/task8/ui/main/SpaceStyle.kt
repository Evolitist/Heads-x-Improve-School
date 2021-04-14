package com.example.task8.ui.main

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceStyle : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if (position == RecyclerView.NO_POSITION) return

        when (position) {
            0 -> {
                outRect.top = 8.toDp()
                outRect.bottom = 4.toDp()
            }
            parent.adapter!!.itemCount - 1 -> {
                outRect.top = 4.toDp()
                outRect.bottom = 8.toDp()
            }
            else -> {
                outRect.top = 4.toDp()
                outRect.bottom = 4.toDp()
            }
        }

        outRect.left = 8.toDp()
        outRect.right = 8.toDp()
    }

    fun Int.toDp() = (this * Resources.getSystem().displayMetrics.density + 0.5F).toInt()

}