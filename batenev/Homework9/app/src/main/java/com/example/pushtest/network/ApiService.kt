package com.example.pushtest.network

import com.example.pushtest.data.MessageData
import com.example.pushtest.data.TokenData
import com.example.pushtest.data.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("registerToken")
    suspend fun sendToken(@Body tokenData: TokenData): Response

    @POST("sendToRandom")
    suspend fun sendMessage(@Body messageData: MessageData): Response
}