package com.example.task8.ui.main.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.SWMapper
import com.example.task8.db.SwDatabase
import com.example.task8.network.planets.PlanetApiModel
import com.example.task8.network.SWApiService
import com.example.task8.ui.main.models.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val apiService: SWApiService,
    private val db: SwDatabase,
) : ViewModel() {

    private val dataFlow = flow {
        var page = 1
        var next: String?
        do {
            val result = apiService.getPlanets(page)
            emit(result.results)
            next = result.next
            page++
        } while (!next.isNullOrEmpty())
    }

    val errors = MutableSharedFlow<String>()
    val planets = MutableLiveData<List<Planet>>()

    fun getPlanets() = viewModelScope.launch {
        try {
            val data = db.dao().getAllPlanets().takeIf { it.isNotEmpty() }
                ?: dataFlow.reduce { accumulator, value -> accumulator + value }.let {
                    val list = it.map(SWMapper::planetToDbModel)
                    db.dao().insertAllPlanets(list)
                    list
                }
            planets.value = data.map(SWMapper::planetToUiModel)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            errors.emit(e.toString())
        }
    }
}