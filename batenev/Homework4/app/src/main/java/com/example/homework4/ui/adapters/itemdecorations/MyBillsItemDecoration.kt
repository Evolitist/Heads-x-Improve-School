package com.example.homework4.ui.adapters.itemdecorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ext.toDp

class MyBillsItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val currentPosition = parent.getChildAdapterPosition(view).let {
            if (it == RecyclerView.NO_POSITION) return else it
        }

        when (currentPosition) {
            in 0..1 -> {
                outRect.top = 12.toDp()
                outRect.bottom = 4.toDp()
            }
            parent.adapter!!.itemCount - 1 -> {
                outRect.top = 4.toDp()
                outRect.bottom = 20.toDp()
            }
            else -> {
                outRect.top = 4.toDp()
                outRect.bottom = 4.toDp()
            }
        }
        if (currentPosition in 0..5) {
            if (currentPosition % 2 == 0) {
                outRect.right = 4.toDp()
                outRect.left = 8.toDp()
            } else {
                outRect.right = 8.toDp()
                outRect.left = 4.toDp()
            }
        } else {
            outRect.right = 8.toDp()
            outRect.left = 8.toDp()
        }

    }
}
