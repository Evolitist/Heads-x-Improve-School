package com.example.homework7.network

import com.example.homework7.network.model.planets.PlanetApiModel
import com.example.homework7.network.model.planets.PlanetsPageApiModel
import com.example.homework7.network.utils.ApiResponse
import com.example.homework7.network.utils.SWApiError
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetsApiService {
    @GET("planets")
    suspend fun getPlanetsPage(
        @Query("page") page: Int
    ): ApiResponse<PlanetsPageApiModel, SWApiError>

    @GET("planets/{id}")
    suspend fun getPlanetById(id: Int): ApiResponse<PlanetApiModel, SWApiError>
}