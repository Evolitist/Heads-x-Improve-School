package com.example.homework7.mappers

import com.example.homework7.db.model.StarshipDBModel
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

fun StarshipApiModel.toDbModel() = StarshipDBModel(
    this.getId(),
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

fun StarshipDBModel.toUiModel() = StarshipUiModel(
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

@JvmName("StarshipApiToUiModel")
fun Collection<StarshipApiModel>.toUiModel() = this.map {
    it.toUiModel()
}

@JvmName("StarshipApiToDbModel")
fun Collection<StarshipApiModel>.toDbModel() = this.map {
    it.toDbModel()
}

@JvmName("StarshipDbToUiModel")
fun Collection<StarshipDBModel>.toUiModel() = this.map {
    it.toUiModel()
}