package com.example.hw3

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.SoundEffectConstants
import android.view.View
import android.widget.Checkable
import android.widget.CompoundButton
import android.widget.FrameLayout
import androidx.core.view.updateLayoutParams
import com.example.hw3.databinding.ListTileBinding


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
                if (getBoolean(R.styleable.ListTileView_hasCheckbox, false)) {
                    binding.listtile.setOnClickListener() { toggle() }
                }
                binding.leading.setImageDrawable(
                    getDrawable(R.styleable.ListTileView_leading)
                )
                if (getDrawable(R.styleable.ListTileView_leading) != null) {
                    binding.leading.visibility = View.VISIBLE
                } else {
                    binding.leading.visibility = View.GONE
                }
                binding.title.text = getString(R.styleable.ListTileView_title)
                if (getString(R.styleable.ListTileView_subtitle) != null) {
                    binding.subtitle.visibility = View.VISIBLE
                    binding.title.updateLayoutParams<MarginLayoutParams> {
                        bottomMargin = 0
                    }
                }
                binding.subtitle.text = getString(R.styleable.ListTileView_subtitle)
                if (getBoolean(R.styleable.ListTileView_hasCheckbox, false)) {
                    binding.trailing.visibility = View.VISIBLE
                } else {
                    binding.trailing.visibility = View.GONE
                }
            } finally {
                recycle()
            }
        }
    }

    override fun setChecked(checked: Boolean) {
        binding.trailing.isChecked = checked
    }

    override fun isChecked(): Boolean {
        return binding.trailing.isChecked
    }

    override fun toggle() {
        binding.trailing.isChecked = !binding.trailing.isChecked
    }

    fun setOnCheckedChangeListener(listener: CompoundButton.OnCheckedChangeListener?) {
        binding.trailing.setOnCheckedChangeListener(listener)
    }
}