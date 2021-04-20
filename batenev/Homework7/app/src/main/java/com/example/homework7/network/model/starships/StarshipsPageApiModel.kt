package com.example.homework7.network.model.starships

import kotlinx.serialization.Serializable

@Serializable
data class StarshipsPageApiModel(
    val count: Int,
    val results: List<StarshipApiModel>
)