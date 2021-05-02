package com.example.pushtest.models

import kotlinx.serialization.Serializable

@Serializable
data class SendToRandom(
        val source: String,
        val message: String,
)
