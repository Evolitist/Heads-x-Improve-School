package com.example.homework_6

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.homework_6.databinding.ListTileBinding

class ListTile @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr) {

    val binding: ListTileBinding = ListTileBinding.inflate(
        LayoutInflater.from(context),
        this, true
    )

    var image1: Drawable?
        get() = binding.image1.drawable
        set(value) {
            binding.image1.setImageDrawable(value)
        }

    var imageAlert: Int?
        get() = binding.imageAlert.visibility
        set(value) {
            if (value != null) {
                binding.imageAlert.visibility = View.VISIBLE
                binding.alert.setTextColor(ContextCompat.getColor(context, R.color.red))
            } else {
                binding.imageAlert.visibility = View.GONE
            }
        }

    var title by binding.title::text

    var serialNumber by binding.serialNumber::text

    var alert by binding.alert::text

    var subtitle1: CharSequence?
        get() = binding.subtitle1.text
        set(value) {
            binding.subtitle1.text = value
        }

    var subtitle2: CharSequence?
        get() = binding.subtitle2.text
        set(value) {
            if (value != null) {
                binding.subtitle2.text = value
                binding.subtitle2.visibility = View.VISIBLE
                binding.editText1.setEms(4)
                binding.editText2.visibility = View.VISIBLE
            } else {
                binding.subtitle2.visibility = View.GONE
                binding.editText1.setEms(9)
                binding.editText2.visibility = View.GONE
            }
        }
    var subtitle3: CharSequence?
        get() = binding.subtitle3.text
        set(value) {
            if (value != null) {
                binding.subtitle3.text = value
                binding.subtitle3.visibility = View.VISIBLE
                binding.editText1.setEms(4)
                binding.editText3.visibility = View.VISIBLE
            } else {
                binding.subtitle3.visibility = View.GONE
                binding.editText1.setEms(14)
                binding.editText3.visibility = View.GONE
            }
        }


    init {
        context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.ListTile, defStyleAttr, 0
        ).run {
            try {
                image1 = getDrawable(R.styleable.ListTile_image1)

                if (getBoolean(R.styleable.ListTile_showAlert, false)) {
                    imageAlert = 1
                }

                title = getString(R.styleable.ListTile_title)

                alert = getString(R.styleable.ListTile_alert)

                serialNumber = getString(R.styleable.ListTile_serialNumber)

                subtitle1 = getString(R.styleable.ListTile_subtitle1)

                subtitle2 = getString(R.styleable.ListTile_subtitle2)

                subtitle3 = getString(R.styleable.ListTile_subtitle3)


            } finally {
                recycle()
            }
        }
    }

}