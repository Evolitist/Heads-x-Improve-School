package com.example.homework_8_retrofit_swapi.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_8_retrofit_swapi.db.ClientDatabase
import com.example.homework_8_retrofit_swapi.db.entities.DBModelPlanets
import com.example.homework_8_retrofit_swapi.network.data.DataList
import com.example.homework_8_retrofit_swapi.network.data.planets.PlanetData
import com.example.homework_8_retrofit_swapi.network.service.SwapiApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ViewModelPlanet @Inject constructor(
    private val database: ClientDatabase,
    private val apiService: SwapiApiService
) : ViewModel() {

    val planetDB = MutableLiveData<List<DBModelPlanets>>()

    private fun getAllPlanet(): Flow<List<PlanetData>> = flow {
        var next: String?
        var planet: DataList<PlanetData>
        var i = 0
        do {
            planet = apiService.getCurrentPlanets(++i)
            next = planet.next
            emit(planet.results)
        } while (next != null)
    }

    fun getPlanet() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.planetsDao().getAllPlanets().isEmpty()) {
                getAllPlanet().collect { starship ->
                    database.planetsDao().insertAllPlanets(
                        starship.map {
                            TypeChangeModule.getPlanetInDB(it)
                        }
                    )
                }
            }
            val dataDB = database.planetsDao().getAllPlanets()
            withContext(Dispatchers.Main) {
                planetDB.value = dataDB
            }
        }
    }

    fun searchPlanetInDB(disc: String) {
        val searchQuery = "%$disc%"
        viewModelScope.launch(Dispatchers.IO) {
            val dataSearch = database.planetsDao().getSearchResultsPlanets(searchQuery)
            withContext(Dispatchers.Main) {
                planetDB.value = dataSearch
            }
        }
    }

    fun removeAllPlanet() {
        viewModelScope.launch(Dispatchers.IO) {
            database.planetsDao().removeAllPlanets()
        }
    }
}