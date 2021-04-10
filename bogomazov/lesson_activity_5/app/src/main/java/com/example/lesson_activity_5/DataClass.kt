package com.example.lesson_activity_5


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataClass(
    var string: String = "Default"

) : Parcelable

val dataActivityFife = DataClass()
