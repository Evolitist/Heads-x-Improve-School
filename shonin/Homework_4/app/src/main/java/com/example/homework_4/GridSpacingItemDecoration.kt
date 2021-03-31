package com.example.homework_4

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


open class GridSpacingItemDecoration(
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
        // Add top margin only for the first item to avoid double space between items
        if ((parent.getChildLayoutPosition(view) == 0) || (parent.getChildLayoutPosition(view) == 1)) {
            outRect.top = spacing + spacing / 2;
        } else {
            outRect.top = 0;
        }
        if ((parent.getChildLayoutPosition(view) == 0) || (parent.getChildLayoutPosition(view) == 2) || (parent.getChildLayoutPosition(view) == 4)) {
            outRect.right = spacing / 2;
        }

        if ((parent.getChildLayoutPosition(view) == 1) || (parent.getChildLayoutPosition(view) == 3) || (parent.getChildLayoutPosition(view) == 5)) {
            outRect.left = spacing / 2;
        }
    }
}