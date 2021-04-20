package com.example.homework7.mappers

import com.example.homework7.network.model.species.SpeciesApiModel
import com.example.homework7.ui.species.model.SpeciesUiModel

fun SpeciesApiModel.toUiModel() = SpeciesUiModel(
    name,
    classification,
    designation,
    averageHeight,
    skinColors,
    hairColors,
    eyeColors,
    averageLifespan,
    language,
    url
)

fun Collection<SpeciesApiModel>.toUiModel() = this.map {
    it.toUiModel()
}