package com.example.lesson3.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.BOTTOM
import androidx.constraintlayout.widget.ConstraintSet.TOP
import androidx.core.view.updateLayoutParams
import com.example.lesson3.R
import com.example.lesson3.databinding.ListTileBinding
import ext.toDp

class ListTileView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet?,
    defAttrSet: Int = 0
) : FrameLayout(context, attrSet, defAttrSet) {

    private val binding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var title = String()
        private set(value) {
            if (value.trim()
                    .isEmpty()
            ) throw IllegalArgumentException("Title should not contain empty string or be null!")
            field = value
            binding.title.text = value
        }
    var subtitle = String()
        private set(value) {
            field = value
            binding.subtitle.text = value
        }
    var leading: Drawable? = null
        private set(value) {
            if (value != null) {
                binding.leading.run {
                    setImageDrawable(value)
                    visibility = View.VISIBLE
                }
                field = value
            } else {
                binding.leading.visibility = View.GONE
            }
        }
    var hasCheckbox = false
        private set(value) {
            field = value
            binding.trailing.visibility = if (value) View.VISIBLE else View.GONE
        }


    init {
        context.theme.obtainStyledAttributes(
            attrSet,
            R.styleable.ListTileView,
            defAttrSet,
            0
        ).run {
            try {
                leading = getDrawable(R.styleable.ListTileView_leading)
                title = getString(R.styleable.ListTileView_title) ?: ""
                subtitle = getString(R.styleable.ListTileView_subtitle) ?: ""
                hasCheckbox = getBoolean(R.styleable.ListTileView_hasCheckbox, false)
            } finally {
                recycle()
            }

            if (isSingleLine()) { // w/o subtitle(single line item)
                applySingleLineLayout()
            } else { // double-line item
                applyTwoLineLayout()
            }

            binding.root.setOnClickListener {
                if (hasCheckbox) {
                    binding.trailing.isChecked = !binding.trailing.isChecked
                }
            }
        }
    }

    private fun isSingleLine(): Boolean = subtitle.trim().isEmpty()
    private fun hasLeading(): Boolean = leading != null

    private fun setTrailingVerticalMargins(verticalMargin: Int) {
        if (hasCheckbox) binding.trailing.updateLayoutParams<MarginLayoutParams> {
            topMargin = verticalMargin
            bottomMargin = verticalMargin
        }
    }

    private fun setLeadingVerticalMargins(verticalMargin: Int) {
        binding.leading.updateLayoutParams<MarginLayoutParams> {
            topMargin = verticalMargin
            bottomMargin = verticalMargin
        }
    }

    private fun applySingleLineLayout() {
        val set = ConstraintSet()
        set.clone(binding.root)

        set.connect(R.id.title, TOP, R.id.horizontalSingleLineGuideline, TOP)
        set.connect(R.id.title, BOTTOM, R.id.horizontalSingleLineGuideline, BOTTOM)
        if (hasLeading()) {
            set.constrainHeight(R.layout.list_tile, 56.toDp())
            setLeadingVerticalMargins(8.toDp())
            setTrailingVerticalMargins(16.toDp())
        } else {
            set.constrainHeight(R.layout.list_tile, 48.toDp())
            setTrailingVerticalMargins(12.toDp())
        }

        set.applyTo(binding.root)
    }

    private fun applyTwoLineLayout() {
        val set = ConstraintSet()
        set.clone(binding.root)

        set.connect(R.id.title, BOTTOM, R.id.horizontalTitleGuideline, BOTTOM)
        set.connect(R.id.subtitle, BOTTOM, R.id.horizontalSubtitleGuideline, BOTTOM)

        if (hasLeading()) {
            set.constrainHeight(R.layout.list_tile, 72.toDp())
            setLeadingVerticalMargins(16.toDp())
            setTrailingVerticalMargins(24.toDp())

            binding.horizontalTitleGuideline.setGuidelineBegin(32.toDp())
            binding.horizontalSubtitleGuideline.setGuidelineEnd(20.toDp())

        } else {
            set.constrainHeight(R.layout.list_tile, 64.toDp())
            setTrailingVerticalMargins(16.toDp())

            binding.horizontalTitleGuideline.setGuidelineBegin(28.toDp())
            binding.horizontalSubtitleGuideline.setGuidelineEnd(20.toDp())
        }

        set.applyTo(binding.root)
    }
}

