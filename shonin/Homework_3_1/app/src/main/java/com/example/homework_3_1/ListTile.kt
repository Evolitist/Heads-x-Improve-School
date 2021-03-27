package com.example.homework_3_1

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.core.view.updateLayoutParams
import com.example.homework_3_1.databinding.ListTileBinding

class ListTile @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    fun check() {
        binding.triling.isChecked = !binding.triling.isChecked
    }

    private val binding: ListTileBinding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this,true)



    init {
        context.theme.obtainStyledAttributes(attributeSet, R.styleable.ListTile, defStyleAttr, 0
        ).run {
            try {
                if (getBoolean(R.styleable.ListTile_hasCheckbox, false)) {
                    binding.main.setOnClickListener() { check() }
                }
                binding.leading.setImageDrawable(
                    getDrawable(R.styleable.ListTile_leading)
                )
                if (getDrawable(R.styleable.ListTile_leading) != null) {
                    binding.leading.visibility = View.VISIBLE
                }
                binding.title.text = getString(R.styleable.ListTile_title)
                if (getString(R.styleable.ListTile_subtitle) != null) {
                    binding.subtitle.visibility = View.VISIBLE
                    binding.title.updateLayoutParams<MarginLayoutParams> {
                        bottomMargin = 0
                    }
                }
                binding.subtitle.text = getString(R.styleable.ListTile_subtitle)
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