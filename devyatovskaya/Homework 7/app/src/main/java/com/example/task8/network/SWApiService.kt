package com.example.task8.network

import com.example.task8.network.Planets.PlanetApiModel
import com.example.task8.network.Planets.PlanetsModel
import com.example.task8.network.StarShips.StarShipApiModel
import com.example.task8.network.StarShips.StarShipModel
import com.example.task8.network.films.FilmApiModel
import com.example.task8.network.films.FilmModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SWApiService {

    @GET("starships")
    suspend fun getStarShips(@Query("page") page:Int) : StarShipModel

    @GET("starships/{id}")
    suspend fun getStarShipsId(id: Int): StarShipApiModel

    @GET("films")
    suspend fun getFilms(@Query("page") page:Int) : FilmModel

    @GET("films/{id}")
    suspend fun geFilmsId(id: Int): FilmApiModel

    @GET("planets")
    suspend fun getPlanets(@Query("page") page:Int) : PlanetsModel

    @GET("planets/{id}")
    suspend fun getPlanetId(id: Int): PlanetApiModel

}