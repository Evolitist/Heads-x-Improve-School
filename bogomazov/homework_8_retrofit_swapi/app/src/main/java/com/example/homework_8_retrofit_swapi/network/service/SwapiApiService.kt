package com.example.homework_8_retrofit_swapi.network.service


import com.example.homework_8_retrofit_swapi.network.data.DataList
import com.example.homework_8_retrofit_swapi.network.data.planets.PlanetData
import com.example.homework_8_retrofit_swapi.network.data.starship.StarshipData
import com.example.homework_8_retrofit_swapi.network.data.vehicles.VehicleData
import retrofit2.http.GET
import retrofit2.http.Query

interface SwapiApiService {
    @GET("starships")
    suspend fun getCurrentStarship(
        @Query("page") page: Int
    ): DataList<StarshipData>

    @GET("vehicles")
    suspend fun getCurrentVehicles(
        @Query("page") page: Int
    ): DataList<VehicleData>

    @GET("planets")
    suspend fun getCurrentPlanets(
        @Query("page") page: Int
    ): DataList<PlanetData>

}