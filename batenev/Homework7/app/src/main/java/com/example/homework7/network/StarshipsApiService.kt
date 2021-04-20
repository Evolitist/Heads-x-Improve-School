package com.example.homework7.network

import com.example.homework7.network.model.starships.StarshipApiModel
import com.example.homework7.network.model.starships.StarshipsPageApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface StarshipsApiService : ApiService {
    @GET("starships")
    suspend fun getStarshipsPage(@Query("page") page: Int): StarshipsPageApiModel

    @GET("starships/{id}")
    suspend fun getStarshipById(id: Int): StarshipApiModel
}