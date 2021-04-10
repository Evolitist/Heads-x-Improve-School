package com.example.homework_5_2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.homework_5_2.databinding.ListTile1Binding

class ListTile1 @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    val binding: ListTile1Binding = ListTile1Binding.inflate(
        LayoutInflater.from(context),
        this, true
    )

    var title by binding.title::text

    init {
        context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.ListTile1, defStyleAttr, 0
        ).run {
            try {

                title = getString(R.styleable.ListTile1_title)

            } finally {
                recycle()
            }
        }
    }
}