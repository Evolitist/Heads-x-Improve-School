package com.example.homework_8.api

import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlanetRepository @Inject constructor(
    private val apiService: SWApiService,
) {

    fun getAllPlanets() = flow { // flow builder
        var i = 2
        var current_page = apiService.getPlanets(1)
        emit(current_page.results)
        while (current_page.next != null) {
            current_page = apiService.getPlanets(i)
            emit(current_page.results)
            i++
        }
    }

}