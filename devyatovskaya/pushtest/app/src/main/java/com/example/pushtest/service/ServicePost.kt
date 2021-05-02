package com.example.pushtest.service

import com.example.pushtest.models.RegisterToken
import com.example.pushtest.models.SendToRandom
import com.example.pushtest.models.StatusData
import retrofit2.http.Body
import retrofit2.http.POST

interface ServicePost {
    @POST("registerToken")
    suspend fun registerToken(@Body item: RegisterToken) : StatusData

    @POST("sendToRandom")
    suspend fun postRand(@Body item: SendToRandom) : StatusData

}