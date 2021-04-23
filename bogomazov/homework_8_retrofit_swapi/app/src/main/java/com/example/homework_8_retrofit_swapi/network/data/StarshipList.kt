package com.example.homework_8_retrofit_swapi.network.data

import kotlinx.serialization.Serializable

@Serializable
data class DataList<T>(
        val count: Int,
        val next: String?,
        val previous: String?,
        val results: List<T>
)