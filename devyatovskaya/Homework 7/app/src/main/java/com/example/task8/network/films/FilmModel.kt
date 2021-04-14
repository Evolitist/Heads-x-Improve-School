package com.example.task8.network.films

import kotlinx.serialization.Serializable

@Serializable
data class FilmModel(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<FilmApiModel>,
)