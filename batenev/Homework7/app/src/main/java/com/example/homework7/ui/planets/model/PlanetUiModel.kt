package com.example.homework7.ui.planets.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetUiModel(
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val url: String
) : Parcelable {
    fun getId(): Int {
        return url[url.length - 2].toInt()
    }

    override fun toString(): String {
        return "Name : $name \n" +
                "Rotation Period : $rotationPeriod \n" +
                "Orbital Period : $orbitalPeriod \n" +
                "Diameter : $diameter \n" +
                "Climate : $climate \n" +
                "Gravity : $gravity \n" +
                "Terrain : $terrain \n" +
                "Surface Water : $surfaceWater \n" +
                "Population : $population \n"
    }
}