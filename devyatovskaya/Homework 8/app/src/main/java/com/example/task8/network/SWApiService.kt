package com.example.task8.network

import com.example.task8.network.planets.PlanetApiModel
import com.example.task8.network.starships.StarShipApiModel
import com.example.task8.network.films.FilmApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SWApiService {

    @GET("starships")
    suspend fun getStarShips(@Query("page") page: Int): Model<StarShipApiModel>

    @GET("films")
    suspend fun getFilms(@Query("page") page: Int): Model<FilmApiModel>

    @GET("planets")
    suspend fun getPlanets(@Query("page") page: Int): Model<PlanetApiModel>
}