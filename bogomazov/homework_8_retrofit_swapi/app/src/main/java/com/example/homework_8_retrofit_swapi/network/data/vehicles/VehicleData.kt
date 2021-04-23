package com.example.homework_8_retrofit_swapi.network.data.vehicles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VehicleData(
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
        @SerialName("vehicle_class") val vehicleClass: String,
        val pilots: List<String>,
        val films: List<String>,
        val created: String,
        val edited: String,
        val url: String
)
