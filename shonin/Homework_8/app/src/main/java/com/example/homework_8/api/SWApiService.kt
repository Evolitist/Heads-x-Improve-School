package com.example.homework_8.api

import com.example.homework_8.api.model.PeopleApiModel
import com.example.homework_8.api.model.PlanetsApiModel
import com.example.homework_8.api.model.StarshipsApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SWApiService {

    @GET("starships")
    suspend fun getStarships(
        @Query("page") page: Int
    ): StarshipsApiModel

    @GET("planets")
    suspend fun getPlanets(
        @Query("page") page: Int
    ): PlanetsApiModel

    @GET("people")
    suspend fun getPeople(
        @Query("page") page: Int
    ): PeopleApiModel

}