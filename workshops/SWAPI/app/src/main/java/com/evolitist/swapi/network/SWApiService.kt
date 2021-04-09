package com.evolitist.swapi.network

import com.evolitist.swapi.network.model.PeopleApiModel
import com.evolitist.swapi.network.model.PersonApiModel
import retrofit2.http.GET
import retrofit2.http.Query

interface SWApiService {

    @GET("people")
    suspend fun getPeople(@Query("page") page: Int): PeopleApiModel

    @GET("people/{id}")
    suspend fun getPerson(id: Int): PersonApiModel
}
