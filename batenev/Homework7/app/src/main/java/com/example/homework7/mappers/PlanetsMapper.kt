package com.example.homework7.mappers

import com.example.homework7.db.model.PlanetDBModel
import com.example.homework7.network.model.planets.PlanetApiModel
import com.example.homework7.ui.planets.model.PlanetUiModel


fun PlanetApiModel.toUiModel() = PlanetUiModel(
    name,
    rotationPeriod,
    orbitalPeriod,
    diameter,
    climate,
    gravity,
    terrain,
    surfaceWater,
    population,
    url
)

fun PlanetDBModel.toUiModel() = PlanetUiModel(
    name,
    rotationPeriod,
    orbitalPeriod,
    diameter,
    climate,
    gravity,
    terrain,
    surfaceWater,
    population,
    url
)

fun PlanetApiModel.toDbModel() = PlanetDBModel(
    this.getId(),
    name,
    rotationPeriod,
    orbitalPeriod,
    diameter,
    climate,
    gravity,
    terrain,
    surfaceWater,
    population,
    url
)

@JvmName("PlanetApiToUiModel")
fun Collection<PlanetApiModel>.toUiModel() = this.map {
    it.toUiModel()
}

@JvmName("PlanetDbToUiModel")
fun Collection<PlanetDBModel>.toUiModel() = this.map {
    it.toUiModel()
}

@JvmName("PlanetApiToDbModel")
fun Collection<PlanetApiModel>.toDbModel() = this.map {
    it.toDbModel()
}