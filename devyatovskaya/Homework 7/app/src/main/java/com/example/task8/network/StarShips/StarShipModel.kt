package com.example.task8.network.StarShips

import kotlinx.serialization.Serializable

@Serializable
data class StarShipModel(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<StarShipApiModel>,
)
