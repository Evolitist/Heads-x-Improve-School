package com.example.task8.network.Planets

import kotlinx.serialization.Serializable

@Serializable
data class PlanetsModel (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PlanetApiModel>,
)