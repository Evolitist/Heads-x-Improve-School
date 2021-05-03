package com.example.homework7.ui.species.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework7.repositories.DatasourceError
import com.example.homework7.repositories.DatasourceResult
import com.example.homework7.repositories.SpeciesRepository
import com.example.homework7.ui.common.FetchViewState
import com.example.homework7.ui.species.model.SpeciesUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeciesListViewModel @Inject constructor(
    private val repository: SpeciesRepository
) : ViewModel() {

    private val _species = MutableLiveData<FetchViewState<List<SpeciesUiModel>>>()
    val species: LiveData<FetchViewState<List<SpeciesUiModel>>> = _species

    init {
        getSpecies()
    }

    fun getNextPage() {
        getSpecies()
    }

    private fun getSpecies() {
        viewModelScope.launch {
            val fetchedData = _species.value?.dataValue()
            _species.value = FetchViewState.Loading
            _species.value = when (val result = repository.getSpecies()) {
                is DatasourceResult.Data -> {
                    val list = mutableListOf<SpeciesUiModel>()
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