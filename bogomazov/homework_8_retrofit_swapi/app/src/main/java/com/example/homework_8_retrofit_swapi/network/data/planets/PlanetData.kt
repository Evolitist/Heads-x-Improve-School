package com.example.homework_8_retrofit_swapi.network.data.planets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetData(
    val name: String,
    @SerialName("rotation_period") val rotationPeriod: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @SerialName("surface_water") val surfaceWater: String,
    val population: String,
    val residents: List<String>?,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)