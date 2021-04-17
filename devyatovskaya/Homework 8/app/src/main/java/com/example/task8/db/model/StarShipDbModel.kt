package com.example.task8.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starships")
data class StarShipDbModel(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "starshipClass") val starshipClass: String,
    @ColumnInfo(name = "manufacturer") val manufacturer: String,
    @ColumnInfo(name = "costInCredits") val costInCredits: String,
    @ColumnInfo(name = "length") val length: String,
    @ColumnInfo(name = "crew") val crew: String,
    @ColumnInfo(name = "passengers") val passengers: String,
    @ColumnInfo(name = "maxAtmospheringSpeed") val maxAtmospheringSpeed: String,
    @ColumnInfo(name = "hyperdriveRating") val hyperdriveRating: String,
    @ColumnInfo(name = "MGLT") val MGLT: String,
    @ColumnInfo(name = "cargoCapacity") val cargoCapacity: String,
    @ColumnInfo(name = "consumables") val consumables: String
)