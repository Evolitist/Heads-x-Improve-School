package com.example.task8.ui.main.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.SWMapper
import com.example.task8.db.SwDatabase
import com.example.task8.network.SWApiService
import com.example.task8.network.starships.StarShipApiModel
import com.example.task8.ui.main.models.Starship
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(
    private val apiService: SWApiService,
    private val db: SwDatabase,
) : ViewModel() {

    private val dataFlow = flow {
        var page = 1
        var next: String?
        do {
            val result = apiService.getStarShips(page)
            emit(result.results)
            next = result.next
            page++
        } while (!next.isNullOrEmpty())
    }
    val errors = MutableSharedFlow<String>()
    val starships = MutableLiveData<List<Starship>>()

    fun getStarships() = viewModelScope.launch {
        try {
            val data = db.dao().getAllShips().takeIf { it.isNotEmpty() }
                ?: dataFlow.reduce { accumulator, value -> accumulator + value }.let {
                    val list = it.map(SWMapper::shipToDbModel)
                    db.dao().insertAllShips(list)
                    list
                }
            starships.value = data.map(SWMapper::shipToUiModel)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            errors.emit(e.toString())
        }
    }

}