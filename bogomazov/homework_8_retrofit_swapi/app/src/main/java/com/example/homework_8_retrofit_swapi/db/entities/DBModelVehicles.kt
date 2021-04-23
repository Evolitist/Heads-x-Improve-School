package com.example.homework_8_retrofit_swapi.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "vehicles")
data class DBModelVehicles(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String?,
    val length: String,
    val maxAtmosphereSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val vehicleClass: String
) : Parcelable
