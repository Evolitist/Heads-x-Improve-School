package com.example.pushtest.network.data

import kotlinx.serialization.Serializable

@Serializable
data class MessageData(
    val source: String,
    val message: String
)