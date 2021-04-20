package com.example.homework7.ui.starships.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StarshipUiModel(
    val name: String,
    val model: String,
    val starshipClass: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val crew: String,
    val passengers: String,
    val maxAtmospheringSpeed: String,
    val hyperdriveRating: String,
    val mglt: String,
    val cargoCapacity: String,
    val consumables: String,
    val url: String
) : Parcelable {
    fun getId(): Int {
        return url[url.length - 2].toInt()
    }
}