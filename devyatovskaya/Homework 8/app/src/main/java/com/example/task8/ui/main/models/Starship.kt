package com.example.task8.ui.main.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Starship(
    val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperdriveRating: String,
    val MGLT: String,
    val starshipClass: String,
) : Parcelable
