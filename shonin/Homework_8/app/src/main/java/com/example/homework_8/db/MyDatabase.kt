package com.example.homework_8.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework_8.db.model.HumanDBModel
import com.example.homework_8.db.model.PlanetDBModel
import com.example.homework_8.db.model.StarshipDBModel

@Database(
    entities = [StarshipDBModel::class, PlanetDBModel::class, HumanDBModel::class],
    version = 3
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun dao(): MyDao

    companion object {

        fun getInstance(context: Context): MyDatabase {
            return Room.databaseBuilder(context, MyDatabase::class.java, "db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
