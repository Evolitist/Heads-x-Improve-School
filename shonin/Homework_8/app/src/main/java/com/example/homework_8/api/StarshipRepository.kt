package com.example.homework_8.api

import kotlinx.coroutines.flow.*
import javax.inject.Inject

class StarshipRepository @Inject constructor(
    private val apiService: SWApiService,
) {

    fun getAllStarships() = flow { // flow builder
        var i = 2
        var current_page = apiService.getStarships(1)
        emit(current_page.results)
        while (current_page.next != null) {
            current_page = apiService.getStarships(i)
            emit(current_page.results)
            i++
        }
    }

}