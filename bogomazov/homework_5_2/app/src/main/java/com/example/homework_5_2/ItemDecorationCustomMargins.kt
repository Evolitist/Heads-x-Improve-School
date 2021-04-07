package com.example.homework_5_2

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class ItemDecorationCustomMargins(
        private val left: Int = 0,
        private val top: Int = 0,
        private val right: Int = 0,
        private val bottom: Int = 0
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {

        val position = parent.getChildAdapterPosition(view)

        if (position == 0) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.set(
                    dip(view.context, left * 2),
                    dip(view.context, 8),
                    dip(view.context, right * 2),
                    dip(view.context, 8)
            )
            return
        }
        if (position == 1) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.set(
                    dip(view.context, left),
                    dip(view.context, 0),
                    dip(view.context, right),
                    dip(view.context, 0)
            )
            return
        }

        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(
                dip(view.context, left),
                dip(view.context, top / 2),
                dip(view.context, right),
                dip(view.context, bottom / 2)
        )

    }

    private fun dip(context: Context, dp: Int) =
            (dp * (context.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt();

}