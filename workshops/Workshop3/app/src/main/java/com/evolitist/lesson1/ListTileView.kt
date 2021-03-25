package com.evolitist.lesson1

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.SoundEffectConstants
import android.widget.Checkable
import android.widget.CompoundButton
import android.widget.FrameLayout
import com.evolitist.lesson1.databinding.ListTileBinding

class ListTileView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr, defStyleRes), Checkable {

    private val binding: ListTileBinding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.ListTileView,
            defStyleAttr,
            0
        ).run {
            try {
                binding.leading.setImageDrawable(
                    getDrawable(R.styleable.ListTileView_image)
                )
                binding.title.text = getString(
                    R.styleable.ListTileView_android_text
                )
            } finally {
                recycle()
            }
        }
    }

    override fun setChecked(checked: Boolean) {
        binding.checkbox.isChecked = checked
    }

    override fun isChecked(): Boolean {
        return binding.checkbox.isChecked
    }

    override fun toggle() {
        binding.checkbox.isChecked = !binding.checkbox.isChecked
    }

    fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener?) {
        binding.checkbox.setOnCheckedChangeListener(listener)
    }

    override fun performClick(): Boolean {
        toggle()
        val handled = super.performClick()
        if (!handled) {
            // View only makes a sound effect if the onClickListener was
            // called, so we'll need to make one here instead.
            playSoundEffect(SoundEffectConstants.CLICK)
        }
        return handled
    }
}
