package com.example.homework_3

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.homework_3.databinding.ListTileBinding


class ListTile @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    private val binding: ListTileBinding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.ListTile,
            defStyleAttr,
            0
        ).run {
            try {
                binding.leading.visibility = getInt(
                    R.styleable.ListTile_visibility_img, View.VISIBLE
                )

                binding.leading.setImageDrawable(
                    getDrawable(R.styleable.ListTile_leading)
                        ?: hiddenImg() //Не могу понять почему не смог использовать лямбду
                )
                //Решение с помощью isVisible
                /*binding.leading.isVisible = getBoolean(
                    R.styleable.ListTile_visibilityImg, false
                )*/

                binding.title.text = getString(
                    R.styleable.ListTile_android_title
                )

                binding.subtitle.text = getString(
                    R.styleable.ListTile_android_subtitle
                ) ?: changeConstrain(binding.title.id, binding.leading.id)

                hiddenTrailing(getBoolean(R.styleable.ListTile_hasCheckbox, false))

            } finally {
                recycle()
            }
        }

    }

    fun toggle() {
        binding.trailing.isChecked = !binding.trailing.isChecked
    }

    private fun hiddenImg(): Drawable? {
        binding.leading.visibility = View.GONE
        return null
    }

    private fun hiddenTrailing(hasCheckBox: Boolean) {
        if (hasCheckBox)
            binding.trailing.visibility = View.VISIBLE
        else
            binding.trailing.visibility = View.GONE
    }

    private fun changeConstrain(idFirst: Int, IdSecond: Int): String? {
        val clParent = binding.parentLayout
        val constraintSet = ConstraintSet()
        constraintSet.clone(clParent)
        constraintSet.connect(idFirst, ConstraintSet.BOTTOM, IdSecond, ConstraintSet.BOTTOM)
        constraintSet.applyTo(clParent)
        return null
    }
}