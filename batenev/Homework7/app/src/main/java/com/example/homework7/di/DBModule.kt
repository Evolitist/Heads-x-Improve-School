package com.example.homework7.di

import android.content.Context
import com.example.homework7.db.SWDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = SWDatabase.getInstance(context)

    @Provides
    @Singleton
    fun providePlanetsDAO(db: SWDatabase) = db.planetsDao()

    @Provides
    @Singleton
    fun provideStarshipsDAO(db: SWDatabase) = db.starshipsDao()

    @Provides
    @Singleton
    fun provideSpeciesDAO(db: SWDatabase) = db.speciesDao()
}