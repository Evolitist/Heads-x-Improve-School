package com.evolitist.swapi.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.evolitist.swapi.db.SWDatabase
import com.evolitist.swapi.mapper.SWMapper
import com.evolitist.swapi.network.SWApiService
import com.evolitist.swapi.paging.PeopleRemoteMediator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    apiService: SWApiService,
    database: SWDatabase,
) : ViewModel() {

    private val dao = database.dao()

    @OptIn(ExperimentalPagingApi::class)
    val peopleList = Pager(
        PagingConfig(
            10,
            enablePlaceholders = false,
        ),
        remoteMediator = PeopleRemoteMediator(apiService, database),
        pagingSourceFactory = dao.getAll().asPagingSourceFactory(),
    ).flow
        .map { it.map(SWMapper::dbToUiModel) }
        .cachedIn(viewModelScope)
}
