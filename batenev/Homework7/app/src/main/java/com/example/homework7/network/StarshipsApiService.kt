package com.example.homework7.network

import com.example.homework7.network.model.starships.StarshipApiModel
import com.example.homework7.network.model.starships.StarshipsPageApiModel
import com.example.homework7.network.utils.ApiResponse
import com.example.homework7.network.utils.SWApiError
import retrofit2.http.GET
import retrofit2.http.Query

interface StarshipsApiService {
    @GET("starships")
    suspend fun getStarshipsPage(
        @Query("page") page: Int
    ): ApiResponse<StarshipsPageApiModel, SWApiError>

    @GET("starships/{id}")
    suspend fun getStarshipById(id: Int): ApiResponse<StarshipApiModel, SWApiError>
}