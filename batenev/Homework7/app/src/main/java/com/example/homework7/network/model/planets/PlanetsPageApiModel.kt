package com.example.homework7.network.model.planets

import kotlinx.serialization.Serializable

@Serializable
data class PlanetsPageApiModel(
    val count: Int,
    val results: List<PlanetApiModel>
)