package com.example.task8.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.task8.db.model.FilmDbModel
import com.example.task8.db.model.PlanetsDbModel
import com.example.task8.db.model.StarShipDbModel

@Database(entities = [FilmDbModel::class, PlanetsDbModel::class, StarShipDbModel::class], version = 1)
abstract class SwDatabase : RoomDatabase() {

    abstract fun dao(): SWDao

    companion object{
        fun getInstance(context: Context):  SwDatabase{
            return Room.databaseBuilder(context, SwDatabase::class.java, "appdatabase")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}