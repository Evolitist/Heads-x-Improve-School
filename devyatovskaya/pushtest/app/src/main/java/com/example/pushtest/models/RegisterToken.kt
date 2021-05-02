package com.example.pushtest.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterToken(
        val username: String,
        val token: String,
)
