package com.example.pushtest.network

import com.example.pushtest.network.service.ClientFBService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object RetrofitModel {

    private const val BASE_URL = "https://us-central1-hxi-push-test.cloudfunctions.net/"

    fun retrofitService(): ClientFBService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory(MediaType.get("application/json")))
            .build()
            .create(ClientFBService::class.java)
    }
}