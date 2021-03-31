package com.example.homework_3_1

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.updateLayoutParams
import com.example.homework_4.R
import com.example.homework_4.databinding.ListTileBinding

class ListTile @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    fun check() {
        binding.triling.isChecked = !binding.triling.isChecked
    }

    val binding: ListTileBinding = ListTileBinding.inflate(
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
                binding.title.updateLayoutParams<MarginLayoutParams> {
                    bottomMargin = 0
                }
            } else {
                binding.subtitle.visibility = View.GONE
            }
        }





    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.ListTile, defStyleAttr, 0
        ).run {
            try {
                leading = getDrawable(R.styleable.ListTile_leading)

                if (getBoolean(R.styleable.ListTile_hasCheckbox, false)) {
                    binding.main.setOnClickListener() { check() }
                }

                title = getString(R.styleable.ListTile_title)

                subtitle = getString(R.styleable.ListTile_subtitle)

                if (getBoolean(R.styleable.ListTile_hasCheckbox, false)) {
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