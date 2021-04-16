package com.example.homework_8.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Starship(
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
    val MGLT: String,
    val cargoCapacity: String,
    val consumables: String,
    val created: String,
    val edited: String,
) : Parcelable