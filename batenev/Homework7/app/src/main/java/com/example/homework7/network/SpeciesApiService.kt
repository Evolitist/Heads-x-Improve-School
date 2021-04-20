package com.example.homework7.network

import com.example.homework7.network.model.species.SpeciesApiModel
import com.example.homework7.network.model.species.SpeciesPageApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SpeciesApiService : ApiService {

    @GET("species")
    suspend fun getSpeciesPage(@Query("page") page: Int): SpeciesPageApiModel

    @GET("species/{id}")
    suspend fun getSpeciesById(id: Int): SpeciesApiModel
}