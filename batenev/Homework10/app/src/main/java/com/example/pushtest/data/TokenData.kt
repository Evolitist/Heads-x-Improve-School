package com.example.pushtest.data

import kotlinx.serialization.Serializable

@Serializable
data class TokenData(
    val username: String,
    val token: String
)

@Serializable
data class MessageData(
    val source: String,
    val message: String
)