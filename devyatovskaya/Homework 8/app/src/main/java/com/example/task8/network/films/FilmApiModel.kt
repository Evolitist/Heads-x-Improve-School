package com.example.task8.network.films

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmApiModel(
    val url: String,
    val title: String,
    @SerialName("episode_id") val episodeId: Int,
    @SerialName("opening_crawl") val openingCrawl: String,
    val director: String,
    val producer: String,
)