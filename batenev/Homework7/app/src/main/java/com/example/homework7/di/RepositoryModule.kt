package com.example.homework7.di

import com.example.homework7.App_HiltComponents
import com.example.homework7.db.dao.PlanetsDAO
import com.example.homework7.db.dao.SpeciesDAO
import com.example.homework7.db.dao.StarshipsDAO
import com.example.homework7.network.PlanetsApiService
import com.example.homework7.network.SpeciesApiService
import com.example.homework7.network.StarshipsApiService
import com.example.homework7.repositories.PlanetsRepository
import com.example.homework7.repositories.SpeciesRepository
import com.example.homework7.repositories.StarshipsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun providePlanetsRepository(api: PlanetsApiService, dao: PlanetsDAO) =
        PlanetsRepository(dao, api)

    @Provides
    fun provideStarshipsRepository(api: StarshipsApiService, dao: StarshipsDAO) =
        StarshipsRepository(dao, api)

    @Provides
    fun provideSpeciesRepository(api: SpeciesApiService, dao: SpeciesDAO) =
        SpeciesRepository(dao, api)
}
