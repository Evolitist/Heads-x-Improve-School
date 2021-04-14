package com.example.task8.network.Planets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PlanetApiModel (
    val name: String,
    val diameter: String,
    @SerialName("rotation_period") val rotationPeriod: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    val gravity: String,
    val population: String,
    val climate: String,
    val terrain: String,
    @SerialName ("surface_water") val surfaceWater: String,
    val created: String,
    val edited: String,
): Parcelable