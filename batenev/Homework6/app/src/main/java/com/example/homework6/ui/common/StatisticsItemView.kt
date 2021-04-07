package com.example.homework6.ui.common

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.BOTTOM
import androidx.constraintlayout.widget.ConstraintSet.TOP
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.homework6.R
import com.example.homework6.databinding.StatisticsListItemBinding
import com.example.homework6.ui.common.StatisticsItemView.ViewType.SINGLE_EDIT_TEXT
import com.example.homework6.ui.common.StatisticsItemView.ViewType.TRIPLE_EDIT_TEXT
import data.MeasurementInfo
import ext.toDp

// API для работы с этой вьюшкой написано не полностью и только под нужды этого задания
class StatisticsItemView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attributeSet, defStyleAttr) {

    private val binding by lazy {
        StatisticsListItemBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    var inputType: ViewType = SINGLE_EDIT_TEXT
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

    var measurementInfo: MeasurementInfo = MeasurementInfo.Warning("")
        set(value) {
            when (value) {
                is MeasurementInfo.Correct -> {
                    setMeasurementInfo(
                        context.getString(
                            R.string.statisticsItem_measuresInfo_correctData,
                            value.firstDate,
                            value.secondDate
                        ),
                        showAsWarning = false,
                        value.firstDate,
                        value.secondDate
                    )
                }
                is MeasurementInfo.Warning -> {
                    setMeasurementInfo(
                        context.getString(
                            R.string.statisticsItem_measuresInfo_warning,
                            value.data
                        ),
                        true
                    )
                }
            }
            field = value
        }


    init {
        context.theme.obtainStyledAttributes(
            attributeSet,
            R.styleable.StatisticsItemView,
            defStyleAttr,
            0
        ).run {
            try {
                inputType =
                    ViewType.values()[getInteger(R.styleable.StatisticsItemView_viewType, 0)]

            } finally {
                recycle()
            }
        }
    }

    private fun switchType(newType: ViewType) {
        if (newType == this.inputType) return

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

    private fun setMeasurementInfo(
        text: String,
        showAsWarning: Boolean = false,
        vararg dates: String
    ) {
        if (showAsWarning) {
            binding.measurementInfo.apply {
                setCompoundDrawablesRelativeWithIntrinsicBounds(
                    ContextCompat.getDrawable(context, R.drawable.ic_alert),
                    null,
                    null,
                    null
                )
                compoundDrawablePadding = 7.toDp()
                setTextColor(ResourcesCompat.getColor(context.resources, R.color.coral, null))
                setText(text)
            }
        } else {
            binding.measurementInfo.apply {
                setTextColor(
                    ResourcesCompat.getColor(
                        context.resources,
                        R.color.charcoal_grey,
                        null
                    )
                )
                setText(
                    decorateMeasurementInfo(text, *dates),
                    TextView.BufferType.SPANNABLE
                )

            }
        }

    }

    private fun decorateMeasurementInfo(string: String, vararg dates: String): SpannableString {
        var finalString = SpannableString(string)
        dates.size
        dates.forEach {
            val start = finalString.indexOf(it)
            val end = start + it.length
            finalString.setSpan(
                StyleSpan(Typeface.BOLD),
                start,
                end,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        return finalString
    }

    enum class ViewType {
        SINGLE_EDIT_TEXT,
        TRIPLE_EDIT_TEXT
    }
}