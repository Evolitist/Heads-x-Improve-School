package com.example.homework_8_retrofit_swapi.di

import android.content.Context
import com.example.homework_8_retrofit_swapi.db.ClientDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ClientDatabase {
        return ClientDatabase.getInstance(context)
    }
}