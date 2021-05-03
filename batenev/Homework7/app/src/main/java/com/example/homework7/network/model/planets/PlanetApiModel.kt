package com.example.homework7.network.model.planets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlanetApiModel(
    val name: String,
    @SerialName("rotation_period") val rotationPeriod: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @SerialName("surface_water") val surfaceWater: String,
    val population: String,
    val url: String
) {
    fun getId(): Long {
        url.split("/").let {
            return it[it.size - 2].toLong()
        }
    }
}