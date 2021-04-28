package com.example.homework_8.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HumanApiModel(
    val name: String,
    @SerialName("birth_year") val birthYear: String,
    @SerialName("eye_color") val eyeColor: String,
    val gender: String,
    val height: String,
    val mass: String,
    @SerialName("skin_color") val skinColor: String,
    @SerialName("hair_color") val hairColor: String,
    val created: String,
    val edited: String,
)