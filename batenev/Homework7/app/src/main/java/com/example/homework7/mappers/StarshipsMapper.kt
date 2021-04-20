package com.example.homework7.mappers

import com.example.homework7.network.model.starships.StarshipApiModel
import com.example.homework7.ui.starships.model.StarshipUiModel

fun StarshipApiModel.toUiModel() = StarshipUiModel(
    name,
    model,
    starshipClass,
    manufacturer,
    costInCredits,
    length,
    crew,
    passengers,
    maxAtmospheringSpeed,
    hyperdriveRating,
    mglt,
    cargoCapacity,
    consumables,
    url
)

fun Collection<StarshipApiModel>.toUiModel() = this.map {
    it.toUiModel()
}