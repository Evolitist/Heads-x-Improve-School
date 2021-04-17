package com.example.task8.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetsDbModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "diameter") val diameter: String,
    @ColumnInfo(name = "orbitalPeriod") val orbitalPeriod: String,
    @ColumnInfo(name = "rotationPeriod") val rotationPeriod: String,
    @ColumnInfo(name = "gravity") val gravity: String,
    @ColumnInfo(name = "population") val population: String,
    @ColumnInfo(name = "climate") val climate: String,
    @ColumnInfo(name = "terrain") val terrain: String,
    @ColumnInfo(name = "surfaceWater") val surfaceWater: String
)
