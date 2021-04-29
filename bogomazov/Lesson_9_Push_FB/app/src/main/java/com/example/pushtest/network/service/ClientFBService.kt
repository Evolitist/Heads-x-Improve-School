package com.example.pushtest.network.service

import com.example.pushtest.network.data.MessageData
import com.example.pushtest.network.data.StatusData
import com.example.pushtest.network.data.UserData
import retrofit2.http.Body
import retrofit2.http.POST

interface ClientFBService {

    @POST("registerToken")
    suspend fun requestDataUser(@Body bodyRequest: UserData): StatusData

    @POST("sendToRandom")
    suspend fun requestMessage(@Body message: MessageData): StatusData

}