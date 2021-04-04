package com.example.homework6.ui.common

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import com.example.homework6.R
import com.example.homework6.databinding.StatisticsListItemBinding
import com.example.homework6.ui.common.StatisticsItemView.ViewType.*

// API для работы с этой вьюшкой написано не полностью и только под нужды этого задания
class StatisticsItemView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr: Int = 0
) : CardView(context, attributeSet, defStyleAttr) {

    private val binding by lazy {
        StatisticsListItemBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    var viewType: ViewType = SINGLE_EDIT_TEXT
        set(value) {
            switchType(value)
            field = value
        }

    var title: CharSequence
        get() = binding.title.text
        set(value) {
            binding.title.text = value
        }

    var serialNumber: CharSequence
        get() = binding.serialNumber.text
        set(value) {
            binding.serialNumber.text = value
        }

    var icon: Drawable? = null
        set(value) {
            binding.icon.setImageDrawable(value)
        }

    var measurementInfo: CharSequence
        get() = binding.measurementInfo.text
        set(value) {
            binding.measurementInfo.text = value
        }


    init {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.StatisticsItemView,
            defStyleAttr,
            0
        ).run {
            try {
                viewType = ViewType.values()[getInteger(R.styleable.StatisticsItemView_viewType, 0)]

            } finally {
                recycle()
            }
        }
    }

    private fun switchType(newType: ViewType) {
        if (newType == this.viewType) return

        when (newType) {
            SINGLE_EDIT_TEXT -> {
                binding.singleEditTextGroup.visibility = View.VISIBLE
                binding.tripleEditTextGroup.visibility = View.GONE
                adjustButtonVerticalPosition(R.id.etNewMeasures_firstType)
            }
            TRIPLE_EDIT_TEXT -> {
                binding.singleEditTextGroup.visibility = View.GONE
                binding.tripleEditTextGroup.visibility = View.VISIBLE
                adjustButtonVerticalPosition(R.id.etNewMeasures_secondType_peak)
            }
        }
    }

    private fun adjustButtonVerticalPosition(newAnchorViewId: Int) {
        val set = ConstraintSet()
        set.clone(binding.constraintLayout)
        set.clear(R.id.btnSubmit, BOTTOM)
        set.clear(R.id.btnSubmit, TOP)
        set.connect(R.id.btnSubmit, TOP, newAnchorViewId, TOP)
        set.connect(R.id.btnSubmit, BOTTOM, newAnchorViewId, BOTTOM)

        set.applyTo(binding.constraintLayout)
    }

    enum class ViewType {
        SINGLE_EDIT_TEXT,
        TRIPLE_EDIT_TEXT
    }
}