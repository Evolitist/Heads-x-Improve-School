package com.evolitist.swapi.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.evolitist.swapi.db.SWDatabase
import com.evolitist.swapi.db.model.PersonDbModel
import com.evolitist.swapi.mapper.SWMapper
import com.evolitist.swapi.network.SWApiService
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Executors

@OptIn(ExperimentalPagingApi::class)
class PeopleRemoteMediator(
    private val apiService: SWApiService,
    database: SWDatabase,
) : RemoteMediator<Int, PersonDbModel>() {

    // This dispatcher prevents `load` requests from running in parallel (paging doesn't quite like it)
    private val mediatorDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    private val dao = database.dao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PersonDbModel>,
    ): MediatorResult {
        return try {
            withContext(mediatorDispatcher) {
                val page = when (loadType) {
                    LoadType.PREPEND -> return@withContext MediatorResult.Success(endOfPaginationReached = true)
                    LoadType.REFRESH -> null
                    LoadType.APPEND -> state.lastItemOrNull()?.pageNumber(state.config.pageSize)?.inc()
                } ?: INITIAL_PAGE

                if (loadType == LoadType.REFRESH) {
                    dao.removeAll()
                }

                val response = apiService.getPeople(page)

                dao.insertAll(response.results.map(SWMapper::apiToDbModel))

                MediatorResult.Success(
                    endOfPaginationReached = response.next.isNullOrEmpty()
                )
            }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    private fun PersonDbModel.pageNumber(pageSize: Int): Int = id / pageSize

    companion object {
        const val INITIAL_PAGE = 1
    }
}
