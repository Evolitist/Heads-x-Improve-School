package com.example.homework7.ext

import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

fun ViewGroup.showSnackBar(text: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(
        this,
        text,
        duration
    ).show()
}