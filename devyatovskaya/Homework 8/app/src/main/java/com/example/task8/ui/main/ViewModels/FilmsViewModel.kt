package com.example.task8.ui.main.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task8.SWMapper
import com.example.task8.db.SwDatabase
import com.example.task8.network.Model
import com.example.task8.network.SWApiService
import com.example.task8.network.films.FilmApiModel
import com.example.task8.ui.main.models.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val apiService: SWApiService,
    private val db: SwDatabase,
) : ViewModel() {

    private val dataFlow = flow {
        var page = 1
        var next: String?
        do {
            val result = apiService.getFilms(page)
            emit(result.results)
            next = result.next
            page++
        } while (!next.isNullOrEmpty())
    }

    val errors = MutableSharedFlow<String>()
    val films = MutableLiveData<List<Film>>()

    fun getFilms() = viewModelScope.launch {
        try {
            val data = db.dao().getAllFilms().takeIf { it.isNotEmpty() }
                ?: dataFlow.reduce { accumulator, value -> accumulator + value }.let {
                    val list = it.map(SWMapper::filmApiToDbModel)
                    db.dao().insertAllFilms(list)
                    list
                }
            films.value = data.map(SWMapper::filmToUiModel)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            errors.emit(e.toString())
        }
    }
}