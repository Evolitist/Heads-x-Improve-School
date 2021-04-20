package com.example.homework7.ui.species

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework7.mappers.toUiModel
import com.example.homework7.network.SpeciesApiService
import com.example.homework7.ui.species.model.SpeciesUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.ceil

@HiltViewModel
class SpeciesViewModel @Inject constructor(
    private val apiService: SpeciesApiService
) : ViewModel() {

    private var speciesCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageItemCount = 10

    private val _species = MutableLiveData<List<SpeciesUiModel>>()
    val species: LiveData<List<SpeciesUiModel>> = _species

    init {
        viewModelScope.launch {
            val response = apiService.getSpeciesPage(1)
            speciesCount = response.count
            currentPage = 1
            _species.value = response.results.toUiModel()
            pageCount = ceil((speciesCount / pageItemCount.toDouble())).toInt()
        }
    }

    fun getNextPage() {
        if ((currentPage + 1) <= pageCount) {
            currentPage++
            getSpeciesPage(currentPage)
        }
    }

    private fun getSpeciesPage(page: Int) {
        viewModelScope.launch {
            val list = mutableListOf<SpeciesUiModel>()
            list.addAll(_species.value!!)
            list.addAll(apiService.getSpeciesPage(page).results.toUiModel())
            _species.value = list
        }
    }
}