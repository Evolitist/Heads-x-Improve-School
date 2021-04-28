package com.example.homework_8.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_8.api.PlanetRepository
import com.example.homework_8.db.MyDatabase
import com.example.homework_8.mapper.MyMapper
import com.example.homework_8.ui.model.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val planetRepository: PlanetRepository,
    database: MyDatabase,
) : ViewModel() {

    private val dao = database.dao()
    val planets = MutableLiveData<List<Planet>>()

    fun getPlanets() {
        viewModelScope.launch {
            if (dao.countAllPlanets() <= 1) {
                dao.insertAllPlanets(planetRepository.getAllPlanets()
                    .reduce { accumulator, value -> accumulator + value }
                    .map(MyMapper::apiToDbPlanetModel))
                planets.value = dao.getAllPlanets().map(MyMapper::dbToPlanetModel)
            } else {
                planets.value = dao.getAllPlanets().map(MyMapper::dbToPlanetModel)
            }

        }
    }

    fun delDb() {
        viewModelScope.launch {
            dao.removeAllPlanets()
            planets.value = emptyList()
        }
    }

    fun searchPlanets(name: String) {
        viewModelScope.launch {
            planets.value = dao.searchAllPlanets("%" + name + "%").map(MyMapper::dbToPlanetModel)
        }
    }

}