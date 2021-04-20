package com.example.homework7.ui.species.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpeciesUiModel(
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val averageLifespan: String,
    val language: String,
    val url: String
) : Parcelable {
    fun getId(): Int {
        return url[url.length - 2].toInt()
    }
}