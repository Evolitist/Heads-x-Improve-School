package com.example.homework_8.mapper

import com.example.homework_8.api.model.HumanApiModel
import com.example.homework_8.api.model.PlanetApiModel
import com.example.homework_8.api.model.StarshipApiModel
import com.example.homework_8.db.model.HumanDBModel
import com.example.homework_8.db.model.PlanetDBModel
import com.example.homework_8.db.model.StarshipDBModel
import com.example.homework_8.ui.model.Human
import com.example.homework_8.ui.model.Planet
import com.example.homework_8.ui.model.Starship

object MyMapper {

    fun apiToDbStarshipModel(apiModel: StarshipApiModel) = StarshipDBModel(
        id = 0,
        name = apiModel.name,
        model = apiModel.model,
        starshipClass = apiModel.starshipClass,
        manufacturer = apiModel.manufacturer,
        costInCredits = apiModel.costInCredits,
        length = apiModel.length,
        crew = apiModel.crew,
        passengers = apiModel.passengers,
        maxAtmospheringSpeed = apiModel.maxAtmospheringSpeed,
        hyperdriveRating = apiModel.hyperdriveRating,
        MGLT = apiModel.MGLT,
        cargoCapacity = apiModel.cargoCapacity,
        consumables = apiModel.consumables,
        created = apiModel.created,
        edited = apiModel.edited
    )

    fun dbToStarshipModel(dbModel: StarshipDBModel) = Starship(
        name = dbModel.name,
        model = dbModel.model,
        starshipClass = dbModel.starshipClass,
        manufacturer = dbModel.manufacturer,
        costInCredits = dbModel.costInCredits,
        length = dbModel.length,
        crew = dbModel.crew,
        passengers = dbModel.passengers,
        maxAtmospheringSpeed = dbModel.maxAtmospheringSpeed,
        hyperdriveRating = dbModel.hyperdriveRating,
        MGLT = dbModel.MGLT,
        cargoCapacity = dbModel.cargoCapacity,
        consumables = dbModel.consumables,
        created = dbModel.created,
        edited = dbModel.edited
    )

    fun apiToDbPlanetModel(apiModel: PlanetApiModel) = PlanetDBModel(
        id = 0,
        name = apiModel.name,
        rotationPeriod = apiModel.rotationPeriod,
        orbitalPeriod = apiModel.orbitalPeriod,
        diameter = apiModel.diameter,
        climate = apiModel.climate,
        gravity = apiModel.gravity,
        terrain = apiModel.terrain,
        surfaceWater = apiModel.surfaceWater,
        population = apiModel.population,
        created = apiModel.created,
        edited = apiModel.edited
    )

    fun dbToPlanetModel(dbModel: PlanetDBModel) = Planet(
        name = dbModel.name,
        rotationPeriod = dbModel.rotationPeriod,
        orbitalPeriod = dbModel.orbitalPeriod,
        diameter = dbModel.diameter,
        climate = dbModel.climate,
        gravity = dbModel.gravity,
        terrain = dbModel.terrain,
        surfaceWater = dbModel.surfaceWater,
        population = dbModel.population,
        created = dbModel.created,
        edited = dbModel.edited
    )

    fun apiToDbHumanModel(apiModel: HumanApiModel) = HumanDBModel(
        id = 0,
        name = apiModel.name,
        birthYear = apiModel.birthYear,
        eyeColor = apiModel.eyeColor,
        gender = apiModel.gender,
        height = apiModel.height,
        mass = apiModel.mass,
        skinColor = apiModel.skinColor,
        hairColor = apiModel.hairColor,
        created = apiModel.created,
        edited = apiModel.edited
    )

    fun dbToHumanModel(dbModel: HumanDBModel) = Human(
        name = dbModel.name,
        birthYear = dbModel.birthYear,
        eyeColor = dbModel.eyeColor,
        gender = dbModel.gender,
        height = dbModel.height,
        mass = dbModel.mass,
        skinColor = dbModel.skinColor,
        hairColor = dbModel.hairColor,
        created = dbModel.created,
        edited = dbModel.edited
    )

}