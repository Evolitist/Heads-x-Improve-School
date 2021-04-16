package com.example.homework_8.api

import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val apiService: SWApiService,
) {

    fun getAllPeople() = flow { // flow builder
        var i = 2
        var current_page = apiService.getPeople(1)
        emit(current_page.results)
        while (current_page.next != null) {
            current_page = apiService.getPeople(i)
            emit(current_page.results)
            i++
        }
    }

}