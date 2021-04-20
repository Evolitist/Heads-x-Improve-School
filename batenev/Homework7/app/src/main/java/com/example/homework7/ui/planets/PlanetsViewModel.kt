package com.example.homework7.ui.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework7.mappers.toUiModel
import com.example.homework7.network.PlanetsApiService
import com.example.homework7.ui.planets.model.PlanetUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.ceil

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val apiService: PlanetsApiService
) : ViewModel() {

    private var planetsCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageItemCount = 10

    private val _planets = MutableLiveData<List<PlanetUiModel>>()
    val planets: LiveData<List<PlanetUiModel>> = _planets

    init {
        viewModelScope.launch {
            val response = apiService.getPlanetsPage(1)
            planetsCount = response.count
            currentPage = 1
            _planets.value = response.results.toUiModel()
            pageCount = ceil((planetsCount / pageItemCount.toDouble())).toInt()
        }
    }

    fun getNextPage() {
        if ((currentPage + 1) <= pageCount) {
            currentPage++
            getPlanetsPage(currentPage)
        }
    }

    private fun getPlanetsPage(page: Int) {
        viewModelScope.launch {
            val list = mutableListOf<PlanetUiModel>()
            list.addAll(_planets.value!!)
            list.addAll(apiService.getPlanetsPage(page).results.toUiModel())
            _planets.value = list
        }
    }
}