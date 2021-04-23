package com.example.homework_8_retrofit_swapi.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_8_retrofit_swapi.db.ClientDatabase
import com.example.homework_8_retrofit_swapi.db.entities.DBModelVehicles
import com.example.homework_8_retrofit_swapi.network.data.DataList
import com.example.homework_8_retrofit_swapi.network.data.vehicles.VehicleData
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
class ViewModelVehicles @Inject constructor(
    private val apiService: SwapiApiService,
    private val database: ClientDatabase
) : ViewModel() {

    val vehiclesDB = MutableLiveData<List<DBModelVehicles>>()

    private fun getAllVehicles(): Flow<List<VehicleData>> = flow {
        var next: String?
        var starship: DataList<VehicleData>
        var i = 0
        do {
            starship = apiService.getCurrentVehicles(++i)
            next = starship.next
            emit(starship.results)
        } while (next != null)
    }

    fun getVehicles() {
        viewModelScope.launch(Dispatchers.IO) {
            if (database.vehiclesDao().getAllVehicles().isEmpty()) {
                getAllVehicles().collect { vehicles ->
                    database.vehiclesDao().insertAllVehicles(
                        vehicles.map {
                            TypeChangeModule.getVehiclesInDB(it)
                        }
                    )
                }
            }
            val dataDB = database.vehiclesDao().getAllVehicles()
            withContext(Dispatchers.Main) {
                vehiclesDB.value = dataDB
            }
        }
    }

    fun searchVehiclesInDB(disc: String) {
        val searchQuery = "%$disc%"
        viewModelScope.launch(Dispatchers.IO) {
            val dataSearch = database.vehiclesDao().getSearchResultsVehicles(searchQuery)
            withContext(Dispatchers.Main) {
                vehiclesDB.value = dataSearch
            }
        }
    }

    fun removeDbVehicles() {
        viewModelScope.launch(Dispatchers.IO) {
            database.vehiclesDao().removeAllVehicles()
        }
    }

}