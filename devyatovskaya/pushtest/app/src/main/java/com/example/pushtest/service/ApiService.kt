package com.example.pushtest.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiService {
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun retrofitService(): ServicePost  {
        return Retrofit.Builder()
            .baseUrl("https://us-central1-hxi-push-test.cloudfunctions.net/")
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory(MediaType.get("application/json")))
            .build()
            .create(ServicePost::class.java)
    }
}