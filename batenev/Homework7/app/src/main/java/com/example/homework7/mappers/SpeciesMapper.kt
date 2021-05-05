package com.example.homework7.mappers

import com.example.homework7.db.model.SpeciesDBModel
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

fun SpeciesApiModel.toDbModel() = SpeciesDBModel(
    this.getId(),
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

fun SpeciesDBModel.toUiModel() = SpeciesUiModel(
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

@JvmName("SpeciesApiToUiModel")
fun Collection<SpeciesApiModel>.toUiModel() = this.map {
    it.toUiModel()
}

@JvmName("SpeciesDbToUiModel")
fun Collection<SpeciesDBModel>.toUiModel() = this.map {
    it.toUiModel()
}

fun Collection<SpeciesApiModel>.toDbModel() = this.map {
    it.toDbModel()
}