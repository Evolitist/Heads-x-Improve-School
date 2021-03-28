package com.evolitist.lesson1

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.SoundEffectConstants
import android.widget.Checkable
import android.widget.CompoundButton
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.use
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import com.evolitist.lesson1.databinding.ListTileBinding

class ListTileView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr, defStyleRes), Checkable {

    private val heightOneLine = context.dpToPx(56)
    private val heightTwoLines = context.dpToPx(72)
    private val titleBaselineOffset = context.dpToPx(32)
    private val binding: ListTileBinding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    var leading: Drawable?
        get() = binding.leading.drawable
        set(value) {
            binding.leading.apply {
                isVisible = value != null
                setImageDrawable(value)
            }
        }
    var title by binding.title::text
    var subtitle: CharSequence?
        get() = binding.subtitle.text
        set(value) {
            val hasSubtitle = value != null
            binding.root.updateLayoutParams {
                height = if (hasSubtitle) heightTwoLines else heightOneLine
            }
            binding.title.apply {
                firstBaselineToTopHeight = if (hasSubtitle) {
                    titleBaselineOffset
                } else 0
                updateLayoutParams<ConstraintLayout.LayoutParams> {
                    verticalBias = if (hasSubtitle) 0f else 0.5f
                }
            }
            binding.subtitle.apply {
                text = value
                isVisible = hasSubtitle
            }
        }
    var hasCheckbox by binding.checkbox::isVisible

    init {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.ListTileView,
            defStyleAttr,
            defStyleRes
        ).use {
            leading = it.getDrawable(R.styleable.ListTileView_leading)
                ?: it.getDrawable(R.styleable.ListTileView_srcCompat)
                ?: it.getDrawable(R.styleable.ListTileView_android_src)
            title = it.getString(R.styleable.ListTileView_title)
                ?: it.getString(R.styleable.ListTileView_android_text)
            subtitle = it.getString(R.styleable.ListTileView_subtitle)
            hasCheckbox = it.getBoolean(
                R.styleable.ListTileView_hasCheckbox,
                false
            )
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

    override fun performClick(): Boolean = if (hasCheckbox) {
        val handled = super.performClick()
        if (!handled) {
            // View only makes a sound effect if the onClickListener was
            // called, so we'll need to make one here instead.
            playSoundEffect(SoundEffectConstants.CLICK)
        }
        handled
    } else {
        super.performClick()
    }
}

fun Context.dpToPx(dp: Number) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    dp.toFloat(),
    resources.displayMetrics
).toInt()
