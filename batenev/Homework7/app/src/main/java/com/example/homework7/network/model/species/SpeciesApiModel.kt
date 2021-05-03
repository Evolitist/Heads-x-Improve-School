package com.example.homework7.network.model.species

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpeciesApiModel(
    val name: String,
    val classification: String,
    val designation: String,
    @SerialName("average_height") val averageHeight: String,
    @SerialName("skin_colors") val skinColors: String,
    @SerialName("hair_colors") val hairColors: String,
    @SerialName("eye_colors") val eyeColors: String,
    @SerialName("average_lifespan") val averageLifespan: String,
    val language: String,
    val url: String
) {
    fun getId(): Long {
        url.split("/").let {
            return it[it.size - 2].toLong()
        }
    }
}