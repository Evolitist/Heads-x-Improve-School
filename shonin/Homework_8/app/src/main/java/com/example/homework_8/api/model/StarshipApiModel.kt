package com.example.homework_8.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StarshipApiModel(
    val name: String,
    val model: String,
    @SerialName("starship_class") val starshipClass: String,
    val manufacturer: String,
    @SerialName("cost_in_credits") val costInCredits: String,
    val length: String,
    val crew: String,
    val passengers: String,
    @SerialName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    @SerialName("hyperdrive_rating") val hyperdriveRating: String,
    val MGLT: String,
    @SerialName("cargo_capacity") val cargoCapacity: String,
    val consumables: String,
    val created: String,
    val edited: String,
)
