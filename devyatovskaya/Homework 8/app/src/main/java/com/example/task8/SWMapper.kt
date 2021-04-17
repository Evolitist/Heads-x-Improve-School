package com.example.task8

import com.example.task8.db.model.FilmDbModel
import com.example.task8.db.model.PlanetsDbModel
import com.example.task8.db.model.StarShipDbModel
import com.example.task8.network.films.FilmApiModel
import com.example.task8.network.planets.PlanetApiModel
import com.example.task8.network.starships.StarShipApiModel
import com.example.task8.ui.main.models.Film
import com.example.task8.ui.main.models.Planet
import com.example.task8.ui.main.models.Starship

object SWMapper {

    fun filmApiToDbModel(apiModel: FilmApiModel) = FilmDbModel(
        id = apiModel.url.split("/").last { it.isNotEmpty() }.toInt(),
        title = apiModel.title,
        episodeId = apiModel.episodeId,
        openingCrawl = apiModel.openingCrawl,
        director = apiModel.director,
        producer = apiModel.producer,
    )

    fun planetToDbModel(apiModel: PlanetApiModel) = PlanetsDbModel(
        id = apiModel.url.split("/").last { it.isNotEmpty() }.toInt(),
        name = apiModel.name,
        diameter = apiModel.diameter,
        climate = apiModel.climate,
        rotationPeriod = apiModel.rotationPeriod,
        orbitalPeriod = apiModel.orbitalPeriod,
        gravity = apiModel.gravity,
        population = apiModel.population,
        terrain = apiModel.terrain,
        surfaceWater = apiModel.surfaceWater
    )

    fun shipToDbModel(apiModel: StarShipApiModel) = StarShipDbModel(
        id = apiModel.url.split("/").last { it.isNotEmpty() }.toInt(),
        name = apiModel.name,
        model = apiModel.model,
        starshipClass = apiModel.starshipClass,
        manufacturer = apiModel.manufacturer,
        costInCredits = apiModel.coastInCredits,
        length = apiModel.coastInCredits,
        crew = apiModel.crew,
        passengers = apiModel.passengers,
        maxAtmospheringSpeed = apiModel.maxAtmospheringSpeed,
        hyperdriveRating = apiModel.hyperdriveRating,
        MGLT = apiModel.MGLT,
        cargoCapacity = apiModel.cargoCapacity,
        consumables = apiModel.consumables,
    )

    fun filmToUiModel(dbEntity: FilmDbModel) = Film(
        id = dbEntity.id,
        title = dbEntity.title,
        episodeId = dbEntity.episodeId,
        openingCrawl = dbEntity.openingCrawl,
        director = dbEntity.director,
        producer = dbEntity.producer,
    )

    fun planetToUiModel(dbEntity: PlanetsDbModel) = Planet(
        id = dbEntity.id,
        name = dbEntity.name,
        diameter = dbEntity.diameter,
        climate = dbEntity.climate,
        rotationPeriod = dbEntity.rotationPeriod,
        orbitalPeriod = dbEntity.orbitalPeriod,
        gravity = dbEntity.gravity,
        population = dbEntity.population,
        terrain = dbEntity.terrain,
        surfaceWater = dbEntity.surfaceWater
    )

    fun shipToUiModel(dbEntity: StarShipDbModel) = Starship(
        id = dbEntity.id,
        name = dbEntity.name,
        model = dbEntity.model,
        starshipClass = dbEntity.starshipClass,
        manufacturer = dbEntity.manufacturer,
        costInCredits = dbEntity.costInCredits,
        length = dbEntity.length,
        crew = dbEntity.crew,
        passengers = dbEntity.passengers,
        maxAtmospheringSpeed = dbEntity.maxAtmospheringSpeed,
        hyperdriveRating = dbEntity.hyperdriveRating,
        MGLT = dbEntity.MGLT,
        cargoCapacity = dbEntity.cargoCapacity,
        consumables = dbEntity.consumables,
    )
}