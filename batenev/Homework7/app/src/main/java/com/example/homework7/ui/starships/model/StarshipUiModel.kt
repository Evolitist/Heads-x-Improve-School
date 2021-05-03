package com.example.homework7.ui.starships.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StarshipUiModel(
    val name: String,
    val model: String,
    val starshipClass: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val crew: String,
    val passengers: String,
    val maxAtmospheringSpeed: String,
    val hyperdriveRating: String,
    val mglt: String,
    val cargoCapacity: String,
    val consumables: String,
    val url: String
) : Parcelable {
    fun getId(): Int {
        return url[url.length - 2].toInt()
    }

    override fun toString(): String {
        return "Name : $name \n" +
                "Model : $model \n" +
                "Starship Class : $starshipClass \n" +
                "Manufacturer : $manufacturer \n" +
                "Cost In Credits : $costInCredits \n" +
                "Length : $length \n" +
                "Crew : $crew \n" +
                "Passengers : $passengers \n" +
                "Max Atmosphering Speed : $maxAtmospheringSpeed \n" +
                "Hyperdrive Rating : $hyperdriveRating \n" +
                "MGLT : $mglt \n" +
                "Cargo Capacity : $cargoCapacity \n" +
                "Consumables : $consumables "
    }
}