package com.example.homework_8.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Human(
    val name: String,
    val birthYear: String,
    val eyeColor: String,
    val gender: String,
    val height: String,
    val mass: String,
    val skinColor: String,
    val hairColor: String,
    val created: String,
    val edited: String,
) : Parcelable
