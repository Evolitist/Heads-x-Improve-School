package com.example.lesson3.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.view.updateLayoutParams
import com.example.lesson3.R
import com.example.lesson3.databinding.MyprofileListItemBinding
import ext.toDp

class MyProfileListItem @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet?,
    defAttrs: Int = 0
) : FrameLayout(context, attrSet, defAttrs) {

    private val binding = MyprofileListItemBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var hint = String()
        set(value) {
            binding.tvHint.text = value
            field = value
        }

    var data = String()
        set(value) {
            binding.tvData.text = value
            field = value
        }

    var hasButton = false
        private set(value) {
            if (value) {
                binding.ibButton.visibility = View.VISIBLE
            } else {
                binding.ibButton.visibility = View.GONE
            }
            field = value
        }

    var buttonPosition: ButtonSide = ButtonSide.RIGHT
        private set(value) {
            if (!hasButton && value == ButtonSide.LEFT) throw IllegalStateException("You can't set button side if hasButton == false")
            when (value) {
                ButtonSide.LEFT -> binding.ibButton.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_exit_24))
                ButtonSide.RIGHT -> binding.ibButton.setImageDrawable(context.getDrawable(R.drawable.ic_baseline_edit_24))
            }
            field = value
        }

    init {
        context.theme.obtainStyledAttributes(
            attrSet,
            R.styleable.MyProfileListItem,
            defAttrs,
            0
        ).run {
            try {
                data = getString(R.styleable.MyProfileListItem_data) ?: throw IllegalStateException(
                    "Data parameter is missing!"
                )
                hasButton = getBoolean(R.styleable.MyProfileListItem_hasButton, false)
                buttonPosition = ButtonSide.values()[
                        getInt(R.styleable.MyProfileListItem_buttonPosition, 0)
                ]

                hint = getString(R.styleable.MyProfileListItem_hint) //If button is on left side
                    ?: if (buttonPosition == ButtonSide.LEFT) { // we can skip the hint
                        ""
                    } else {
                        throw IllegalStateException("Hint parameter is missing!")
                    }

            } finally {
                recycle()
            }

            adjustButtonPosition()
        }
    }

    private fun adjustButtonPosition() {
        if (hasButton) {
            if (buttonPosition == ButtonSide.LEFT) {
                with(binding) {
                    tvHint.visibility = View.GONE
                    tvData.updateLayoutParams<MarginLayoutParams> {
                        topMargin = 32.toDp()
                        bottomMargin = 28.toDp()
                        marginStart = 31.toDp()
                    }
                    ibButton.updateLayoutParams<MarginLayoutParams> {
                        marginStart = 16.toDp()
                        topMargin = 29.toDp()
                        bottomMargin = 31.toDp()
                    }
                    val set = ConstraintSet()
                    set.clone(root)

                    set.clear(R.id.ibButton, END) // Move button to left position
                    set.connect(R.id.ibButton, START, PARENT_ID, START)

                    set.clear(R.id.tvData, END) // Adjust data text view
                    set.connect(R.id.tvData, END, PARENT_ID, END)
                    set.connect(R.id.tvData, START, R.id.ibButton, END)
                    set.connect(R.id.tvData, TOP, R.id.ibButton, TOP)
                    set.connect(R.id.tvData, BOTTOM, R.id.ibButton, BOTTOM)

                    set.applyTo(root)
                    requestLayout()
                }
            }
        }
    }

    fun setButtonOnClickListener(onClick: () -> Unit) {
        if (hasButton) {
            binding.ibButton.setOnClickListener {
                onClick.invoke()
            }
        }
    }

    enum class ButtonSide {
        RIGHT,
        LEFT
    }
}