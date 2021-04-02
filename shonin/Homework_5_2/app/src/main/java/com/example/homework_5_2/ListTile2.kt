package com.example.homework_5_2

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.homework_5_2.databinding.ListTile2Binding

class ListTile2 @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    val binding: ListTile2Binding = ListTile2Binding.inflate(
        LayoutInflater.from(context),
        this, true
    )

    var image: Drawable?
        get() = binding.image.drawable
        set(value) {
            binding.image.setImageDrawable(value)
            if (value != null) {
                binding.image.visibility = View.VISIBLE
            } else {
                binding.image.visibility = View.GONE
            }
        }

    var title by binding.title::text

    init {
        context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.ListTile2, defStyleAttr, 0
        ).run {
            try {
                image = getDrawable(R.styleable.ListTile2_image)

                title = getString(R.styleable.ListTile2_title)

            } finally {
                recycle()
            }
        }
    }
}