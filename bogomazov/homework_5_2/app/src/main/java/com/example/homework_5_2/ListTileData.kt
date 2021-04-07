package com.example.homework_5_2

import android.graphics.drawable.Drawable

data class ListTileData(
        val title: String,
        val nameTile: String = "default",
        val subtitle: String = "default",
        val image: Drawable? = null
)
