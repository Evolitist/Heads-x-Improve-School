package com.example.homework_4

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.homework_4.databinding.ListTile2Binding

class ListTile2 @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    val binding: ListTile2Binding = ListTile2Binding.inflate(
        LayoutInflater.from(context),
        this,true)

    var leading: Drawable?
        get() = binding.leading.drawable
        set(value) {
            binding.leading.setImageDrawable(value)
            if (value != null) {
                binding.leading.visibility = View.VISIBLE
            } else {
                binding.leading.visibility = View.GONE
            }
        }
    var title by binding.title::text

    var subtitle: CharSequence?
        get() = binding.subtitle.text
        set(value) {
            if (value != null) {
                binding.subtitle.text = value
                binding.subtitle.visibility = View.VISIBLE
            } else {
                binding.subtitle.visibility = View.GONE
            }
        }

    var color: Int?
        get() = binding.subtitle.currentTextColor
        set(value) {
            if (value != null) {
                binding.subtitle.setTextColor(value)
            }
        }





    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.ListTile, defStyleAttr, 0
        ).run {
            try {
                leading = getDrawable(R.styleable.ListTile2_leading2)

                title = getString(R.styleable.ListTile2_title2)

                subtitle = getString(R.styleable.ListTile2_subtitle2)

            } finally {
                recycle()
            }
        }
    }

}