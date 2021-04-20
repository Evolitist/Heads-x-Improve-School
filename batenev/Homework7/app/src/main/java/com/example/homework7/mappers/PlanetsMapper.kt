package com.example.homework7.mappers

import com.example.homework7.network.PlanetsApiService
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

fun Collection<PlanetApiModel>.toUiModel() = this.map {
    it.toUiModel()
}