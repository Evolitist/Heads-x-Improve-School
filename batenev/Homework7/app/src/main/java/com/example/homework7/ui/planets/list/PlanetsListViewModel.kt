package com.example.homework7.ui.planets.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework7.repositories.DatasourceError
import com.example.homework7.repositories.DatasourceResult
import com.example.homework7.repositories.PlanetsRepository
import com.example.homework7.ui.common.FetchViewState
import com.example.homework7.ui.planets.model.PlanetUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsListViewModel @Inject constructor(
    private val repository: PlanetsRepository
) : ViewModel() {

    private val _planets = MutableLiveData<FetchViewState<List<PlanetUiModel>>>()
    val planets: LiveData<FetchViewState<List<PlanetUiModel>>> = _planets

    init {
        getPlanets()
    }

    fun getNextPage() {
        getPlanets()
    }

    private fun getPlanets() {
        viewModelScope.launch {
            val fetchedData = _planets.value?.dataValue()
            _planets.value = FetchViewState.Loading
            _planets.value = when (val result = repository.getPlanets()) {
                is DatasourceResult.Data -> {
                    val list = mutableListOf<PlanetUiModel>()
                    fetchedData?.let { list.addAll(it) }
                    list.addAll(result.data)
                    FetchViewState.Data(list)
                }
                is DatasourceResult.Error -> {
                    when (result.type) {
                        DatasourceError.EMPTY -> FetchViewState.Empty
                        DatasourceError.NETWORK -> FetchViewState.NetworkError
                        DatasourceError.UNKNOWN -> FetchViewState.UnknownError
                        DatasourceError.API -> FetchViewState.ApiError
                    }
                }
            }
        }
    }
}