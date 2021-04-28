package com.example.hw6.ui.fragments.adapter

import android.graphics.drawable.Drawable
import android.text.Spannable

data class PlaceholderItem(
    val title: String,
    val image: Drawable?,
    val subtext: Spannable?,
    val type: Int
)
