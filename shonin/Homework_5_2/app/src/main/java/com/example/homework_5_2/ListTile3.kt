package com.example.homework_5_2

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.homework_5_2.databinding.ListTile3Binding

class ListTile3 @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    val binding: ListTile3Binding = ListTile3Binding.inflate(
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
    var subtitle by binding.subtitle::text
    var adress by binding.adress::text

    init {
        context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.ListTile3, defStyleAttr, 0
        ).run {
            try {
                image = getDrawable(R.styleable.ListTile3_image)

                title = getString(R.styleable.ListTile3_title)

                subtitle = getString(R.styleable.ListTile3_subtitle)

                adress = getString(R.styleable.ListTile3_adress)

            } finally {
                recycle()
            }
        }
    }

}