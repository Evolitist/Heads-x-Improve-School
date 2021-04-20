package com.example.homework7.di

import com.example.homework7.network.PlanetsApiService
import com.example.homework7.network.SpeciesApiService
import com.example.homework7.network.StarshipsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(MediaType.get("application/json"))
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideStarshipsApiService(retrofit: Retrofit): StarshipsApiService {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun providePlanetsApiService(retrofit: Retrofit): PlanetsApiService {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideSpeciesApiService(retrofit: Retrofit): SpeciesApiService {
        return retrofit.create()
    }
}