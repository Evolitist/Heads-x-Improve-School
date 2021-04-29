package com.example.homework_8_retrofit_swapi.ui

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.roundToInt

class DecoratorItemRecyclerView(
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
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val lastPosition = state.itemCount-1

        if (position == 0) {
            outRect.set(
                dip(view.context, left),
                dip(view.context, top),
                dip(view.context, right),
                dip(view.context, bottom/2)
            )
            return
        }

        if (position == lastPosition) {
            outRect.set(
                dip(view.context, left),
                dip(view.context, top/2),
                dip(view.context, right),
                dip(view.context, bottom)
            )
            return
        }

        outRect.set(
            dip(view.context, left),
            dip(view.context, top/2),
            dip(view.context, right),
            dip(view.context, bottom/2)
        )
    }

    private fun dip(context: Context, dp: Int) =
        (dp * (context.resources.displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt();

}