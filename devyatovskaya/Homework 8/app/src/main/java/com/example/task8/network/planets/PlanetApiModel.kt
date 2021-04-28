package com.example.task8.network.planets

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetApiModel (
    val url: String,
    val name: String,
    val diameter: String,
    @SerialName("rotation_period") val rotationPeriod: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    val gravity: String,
    val population: String,
    val climate: String,
    val terrain: String,
    @SerialName ("surface_water") val surfaceWater: String,
)