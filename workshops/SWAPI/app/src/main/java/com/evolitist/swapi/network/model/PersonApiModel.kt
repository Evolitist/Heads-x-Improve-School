package com.evolitist.swapi.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonApiModel(
    @SerialName("name") val name: String,
    @SerialName("height") val height: String,
    @SerialName("mass") val mass: String,
    @SerialName("hair_color") val hairColor: String,
    @SerialName("skin_color") val skinColor: String,
    @SerialName("eye_color") val eyeColor: String,
    @SerialName("birth_year") val birthYear: String,
    @SerialName("gender") val gender: String,
    @SerialName("url") val url: String,
)
