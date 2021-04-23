package com.example.homework_8_retrofit_swapi.network.data.starship

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarshipData(
        val name: String,
        val model: String,
        val manufacturer: String,
        @SerialName("cost_in_credits") val costInCredits: String?,
        val length: String,
        @SerialName("max_atmosphering_speed") val maxAtmosphereSpeed: String,
        val crew: String,
        val passengers: String,
        @SerialName("cargo_capacity") val cargoCapacity: String,
        val consumables: String,
        @SerialName("hyperdrive_rating") val hyperdriveRating: String,
        val MGLT: String,
        @SerialName("starship_class") val starshipClass: String,
        val pilots: List<String>,
        val films: List<String>,
        val created: String,
        val edited: String,
        val url: String
)