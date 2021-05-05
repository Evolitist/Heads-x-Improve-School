package com.example.homework7.network.model.starships

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
    @SerialName("MGLT") val mglt: String,
    @SerialName("cargo_capacity") val cargoCapacity: String,
    val consumables: String,
    val url: String
) {
    fun getId(): Long {
        url.split("/").let {
            return it[it.size - 2].toLong()
        }
    }
}