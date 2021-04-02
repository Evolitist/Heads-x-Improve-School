package com.example.homework_4

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class GridSpacingItemDecoration(
    private val spacing: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = spacing;
        outRect.right = spacing;
        outRect.bottom = spacing;
        var id = parent.getChildLayoutPosition(view)
        if (id == 0) {
            outRect.top = spacing
        }
    }
}