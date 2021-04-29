package com.example.pushtest.network.data

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val username: String,
    val token: String
)
