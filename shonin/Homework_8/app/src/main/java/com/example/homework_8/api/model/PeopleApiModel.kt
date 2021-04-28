package com.example.homework_8.api.model

import kotlinx.serialization.Serializable

@Serializable
data class PeopleApiModel(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<HumanApiModel>
)