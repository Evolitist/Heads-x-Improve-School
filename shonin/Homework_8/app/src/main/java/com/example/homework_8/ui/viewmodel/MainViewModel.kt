package com.example.homework_8.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_8.api.StarshipRepository
import com.example.homework_8.db.MyDatabase
import com.example.homework_8.mapper.MyMapper
import com.example.homework_8.ui.model.Starship
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val starshipRepository: StarshipRepository,
    database: MyDatabase,
) : ViewModel() {

    private val dao = database.dao()
    val starships = MutableLiveData<List<Starship>>()

    fun getStarships() {
        viewModelScope.launch {
            if (dao.countAllStarships() <= 1) {
                dao.insertAllStarships(starshipRepository.getAllStarships()
                    .reduce { accumulator, value -> accumulator + value }
                    .map(MyMapper::apiToDbStarshipModel))
                starships.value = dao.getAllStarships().map(MyMapper::dbToStarshipModel)
            } else {
                starships.value = dao.getAllStarships().map(MyMapper::dbToStarshipModel)
            }

        }
    }

    fun delDb() {
        viewModelScope.launch {
            dao.removeAllStarships()
            starships.value = emptyList()
        }
    }

    fun searchStarship(name: String) {
        viewModelScope.launch {
            starships.value =
                dao.searchAllStarships("%" + name + "%").map(MyMapper::dbToStarshipModel)
        }
    }

}