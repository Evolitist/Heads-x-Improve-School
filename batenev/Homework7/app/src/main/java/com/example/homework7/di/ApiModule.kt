package com.example.homework7.di

import android.util.Log
import com.example.homework7.network.PlanetsApiService
import com.example.homework7.network.SpeciesApiService
import com.example.homework7.network.StarshipsApiService
import com.example.homework7.network.utils.ApiResponseAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addCallAdapterFactory(ApiResponseAdapterFactory())
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message -> Log.d("HttpLogger", message) }.apply {
            level = HttpLoggingInterceptor.Level.HEADERS
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