package com.example.homework7.network

import com.example.homework7.network.model.planets.PlanetApiModel
import com.example.homework7.network.model.planets.PlanetsPageApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetsApiService : ApiService {
    @GET("planets")
    suspend fun getPlanetsPage(@Query("page") page: Int): PlanetsPageApiModel

    @GET("planets/{id}")
    suspend fun getPlanetById(id: Int): PlanetApiModel
}