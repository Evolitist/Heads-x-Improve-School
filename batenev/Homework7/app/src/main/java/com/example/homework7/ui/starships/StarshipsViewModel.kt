package com.example.homework7.ui.starships

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework7.mappers.toUiModel
import com.example.homework7.network.StarshipsApiService
import com.example.homework7.ui.starships.model.StarshipUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.ceil

@HiltViewModel
class StarshipsViewModel @Inject constructor(
    private val apiService: StarshipsApiService
) : ViewModel() {

    private var starshipsCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageItemCount = 10

    private val _starships = MutableLiveData<List<StarshipUiModel>>()
    val starships: LiveData<List<StarshipUiModel>> = _starships

    init {
        viewModelScope.launch {
            val response = apiService.getStarshipsPage(1)
            starshipsCount = response.count
            currentPage = 1
            _starships.value = response.results.toUiModel()
            pageCount = ceil((starshipsCount / pageItemCount.toDouble())).toInt()
        }
    }

    fun getNextPage() {
        if ((currentPage + 1) <= pageCount) {
            currentPage++
            getStarshipsPage(currentPage)
        }
    }

    private fun getStarshipsPage(page: Int) {
        viewModelScope.launch {
            val list = mutableListOf<StarshipUiModel>()
            list.addAll(_starships.value!!)
            list.addAll(apiService.getStarshipsPage(page).results.toUiModel())
            _starships.value = list
        }
    }

}