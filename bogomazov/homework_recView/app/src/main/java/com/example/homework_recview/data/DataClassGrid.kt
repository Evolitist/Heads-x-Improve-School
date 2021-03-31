package com.example.homework_recview.data

import android.graphics.drawable.Drawable

data class DataClassGrid(
        val title: String,
        val subtitle: String? = null,
        val images: Drawable? = null,
        val warning: Boolean = false
)