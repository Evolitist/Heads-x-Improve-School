package com.example.task8.ui.main.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Planet(
    val id: Int,
    val name: String,
    val diameter: String,
    val orbitalPeriod: String,
    val rotationPeriod: String,
    val gravity: String,
    val population: String,
    val climate: String,
    val terrain: String,
    val surfaceWater: String,
) : Parcelable
