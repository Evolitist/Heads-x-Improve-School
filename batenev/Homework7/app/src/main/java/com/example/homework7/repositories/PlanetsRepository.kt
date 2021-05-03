package com.example.homework7.repositories

import com.example.homework7.db.dao.PlanetsDAO
import com.example.homework7.mappers.toDbModel
import com.example.homework7.mappers.toUiModel
import com.example.homework7.network.PlanetsApiService
import com.example.homework7.network.utils.ApiResponse
import com.example.homework7.ui.planets.model.PlanetUiModel
import javax.inject.Inject
import kotlin.math.ceil

class PlanetsRepository @Inject constructor(
    private val dao: PlanetsDAO,
    private val apiService: PlanetsApiService
) {
    private var planetsCount = 0
    private var currentPage = 0
    private var pageCount = 0
    private val pageSize = 10

    suspend fun getPlanets(): DatasourceResult<List<PlanetUiModel>> {
        if (pageCount == 0) {
            val dbCount = dao.getCount()
            if (dbCount > 0) {
                currentPage = ceil(dbCount / pageSize.toDouble()).toInt()
                pageCount = currentPage
                return DatasourceResult.Data(dao.getAll().toUiModel())
            }
        }
        return when (val response = apiService.getPlanetsPage(currentPage + 1)) {
            is ApiResponse.Success -> {
                if (planetsCount == 0) {
                    planetsCount = response.data.count
                    pageCount = ceil((planetsCount / pageSize.toDouble())).toInt()
                }
                currentPage++
                dao.insertAll(response.data.results.toDbModel())
                DatasourceResult.Data(response.data.results.toUiModel())
            }
            is ApiResponse.ApiError -> {
                if (response.code == 404) {
                    DatasourceResult.Error(DatasourceError.EMPTY)
                } else {
                    DatasourceResult.Error(DatasourceError.API)
                }
            }
            is ApiResponse.NetworkError -> {
                DatasourceResult.Error(DatasourceError.NETWORK)
            }
            is ApiResponse.UnknownError -> {
                DatasourceResult.Error(DatasourceError.UNKNOWN)
            }
            ApiResponse.Empty -> {
                DatasourceResult.Error(DatasourceError.EMPTY)
            }
        }
    }
}
