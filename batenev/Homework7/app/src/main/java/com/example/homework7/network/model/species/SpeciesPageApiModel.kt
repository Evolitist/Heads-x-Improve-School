package com.example.homework7.network.model.species

import kotlinx.serialization.Serializable

@Serializable
data class SpeciesPageApiModel(
    val count: Int,
    val results: List<SpeciesApiModel>
)