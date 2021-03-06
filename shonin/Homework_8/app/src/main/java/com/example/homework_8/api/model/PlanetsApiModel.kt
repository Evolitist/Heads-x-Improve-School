package com.example.homework_8.api.model

import kotlinx.serialization.Serializable

@Serializable
data class PlanetsApiModel(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PlanetApiModel>
)