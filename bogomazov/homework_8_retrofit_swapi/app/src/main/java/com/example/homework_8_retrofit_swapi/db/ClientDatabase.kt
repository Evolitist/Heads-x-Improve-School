package com.example.homework_8_retrofit_swapi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework_8_retrofit_swapi.db.daos.PlanetsDao
import com.example.homework_8_retrofit_swapi.db.daos.StarshipsDao
import com.example.homework_8_retrofit_swapi.db.daos.VehiclesDao
import com.example.homework_8_retrofit_swapi.db.entities.DBModelPlanets
import com.example.homework_8_retrofit_swapi.db.entities.DBModelStarship
import com.example.homework_8_retrofit_swapi.db.entities.DBModelVehicles


@Database(
    entities = [DBModelStarship::class, DBModelVehicles::class, DBModelPlanets::class],
    version = 11
)
abstract class ClientDatabase : RoomDatabase() {

    abstract fun planetsDao(): PlanetsDao
    abstract fun starshipsDao(): StarshipsDao
    abstract fun vehiclesDao(): VehiclesDao

    companion object {
        fun getInstance(context: Context): ClientDatabase {
            return Room.databaseBuilder(context, ClientDatabase::class.java, "swapidb")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}