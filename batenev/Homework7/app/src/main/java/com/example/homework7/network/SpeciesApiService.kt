package com.example.homework7.network

import com.example.homework7.network.model.species.SpeciesApiModel
import com.example.homework7.network.model.species.SpeciesPageApiModel
import com.example.homework7.network.utils.ApiResponse
import com.example.homework7.network.utils.SWApiError
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeciesApiService {

    @GET("species")
    suspend fun getSpeciesPage(
        @Query("page") page: Int
    ): ApiResponse<SpeciesPageApiModel, SWApiError>

    @GET("species/{id}")
    suspend fun getSpeciesById(id: Int): ApiResponse<SpeciesApiModel, SWApiError>
}