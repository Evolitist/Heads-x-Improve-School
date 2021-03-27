package com.example.homework_3_2

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.updateLayoutParams
import com.example.homework_3_2.databinding.ListTileBinding

class ListTile @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding: ListTileBinding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this,true)

    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.ListTile, defStyleAttr, 0
        ).run {
            try {
                binding.title.text = getString(R.styleable.ListTile_title)
                if (getString(R.styleable.ListTile_subtitle) != null) {
                    binding.subtitle.visibility = View.VISIBLE
                    binding.title.updateLayoutParams<MarginLayoutParams> {
                        bottomMargin = 0
                    }
                }
                binding.subtitle.text = getString(R.styleable.ListTile_subtitle)
                if (getBoolean(R.styleable.ListTile_hasIcon, false)) {
                    binding.triling.visibility =  View.VISIBLE
                } else {
                    binding.triling.visibility =  View.GONE
                }

            } finally {
                recycle()
            }
        }
    }

}