package com.example.homework7.ui.starships.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework7.repositories.DatasourceError
import com.example.homework7.repositories.DatasourceResult
import com.example.homework7.repositories.StarshipsRepository
import com.example.homework7.ui.common.FetchViewState
import com.example.homework7.ui.starships.model.StarshipUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarshipsListViewModel @Inject constructor(
    private val repository: StarshipsRepository
) : ViewModel() {

    private val _starships = MutableLiveData<FetchViewState<List<StarshipUiModel>>>()
    val starships: LiveData<FetchViewState<List<StarshipUiModel>>> = _starships

    init {
        getStarships()
    }

    fun getNextPage() {
        getStarships()
    }

    private fun getStarships() {
        viewModelScope.launch {
            val fetchedData = _starships.value?.dataValue()
            _starships.value = FetchViewState.Loading
            _starships.value = when (val result = repository.getStarships()) {
                is DatasourceResult.Data -> {
                    val list = mutableListOf<StarshipUiModel>()
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