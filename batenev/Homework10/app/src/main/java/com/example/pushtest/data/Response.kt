package com.example.pushtest.data

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val message: String = ""
)