package com.example.homework_fragment_6.data

import android.graphics.drawable.Drawable
import android.text.Spannable

data class DataListTile(
        val title: String,
        val textWarning: String? = null,
        val id: String,
        val image: Drawable?,
        val textInfo: Spannable? = null
)