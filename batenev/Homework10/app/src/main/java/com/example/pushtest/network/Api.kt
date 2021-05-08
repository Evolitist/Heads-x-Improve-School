package com.example.pushtest.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType

//Жизнь без DI...
object Api {
    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("https://us-central1-hxi-push-test.cloudfunctions.net/")
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory(MediaType.get("application/json"))
        )
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}