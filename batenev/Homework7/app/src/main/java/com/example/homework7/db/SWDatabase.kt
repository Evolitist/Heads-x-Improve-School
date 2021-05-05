package com.example.homework7.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework7.db.dao.PlanetsDAO
import com.example.homework7.db.dao.SpeciesDAO
import com.example.homework7.db.dao.StarshipsDAO
import com.example.homework7.db.model.PlanetDBModel
import com.example.homework7.db.model.SpeciesDBModel
import com.example.homework7.db.model.StarshipDBModel

@Database(
    entities = [PlanetDBModel::class, SpeciesDBModel::class, StarshipDBModel::class],
    version = 1
)
abstract class SWDatabase : RoomDatabase() {

    abstract fun planetsDao(): PlanetsDAO
    abstract fun speciesDao(): SpeciesDAO
    abstract fun starshipsDao(): StarshipsDAO

    companion object {
        const val NAME = "swdb"
        fun getInstance(context: Context): SWDatabase {
            return Room.databaseBuilder(context, SWDatabase::class.java, NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}