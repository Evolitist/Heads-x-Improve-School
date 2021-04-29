package com.example.homework_8_retrofit_swapi.model

import com.example.homework_8_retrofit_swapi.db.entities.DBModelPlanets
import com.example.homework_8_retrofit_swapi.db.entities.DBModelStarship
import com.example.homework_8_retrofit_swapi.db.entities.DBModelVehicles
import com.example.homework_8_retrofit_swapi.network.data.planets.PlanetData
import com.example.homework_8_retrofit_swapi.network.data.starship.StarshipData
import com.example.homework_8_retrofit_swapi.network.data.vehicles.VehicleData
import java.lang.NumberFormatException

object TypeChangeModule {
    private fun getID(url: String): Int {
        return try {
            url.split("/").last { it != "" }.toInt()
        } catch (e: NumberFormatException) {
            0
        }
    }

    fun getStarshipInDB(starship: StarshipData): DBModelStarship {
        return DBModelStarship(
            id = getID(starship.url),
            name = starship.name,
            model = starship.model,
            manufacturer = starship.manufacturer,
            costInCredits = starship.costInCredits,
            length = starship.length,
            maxAtmosphereSpeed = starship.maxAtmosphereSpeed,
            crew = starship.crew,
            passengers = starship.passengers,
            cargoCapacity = starship.cargoCapacity,
            consumables = starship.consumables,
            hyperdriveRating = starship.hyperdriveRating,
            MGLT = starship.MGLT,
            starshipClass = starship.starshipClass
        )
    }

    fun getVehiclesInDB(vehicleData: VehicleData): DBModelVehicles {
        return DBModelVehicles(
            id = getID(vehicleData.url),
            name = vehicleData.name,
            model = vehicleData.model,
            manufacturer = vehicleData.manufacturer,
            costInCredits = vehicleData.costInCredits,
            length = vehicleData.length,
            maxAtmosphereSpeed = vehicleData.maxAtmosphereSpeed,
            crew = vehicleData.crew,
            passengers = vehicleData.passengers,
            cargoCapacity = vehicleData.cargoCapacity,
            consumables = vehicleData.consumables,
            vehicleClass = vehicleData.vehicleClass
        )
    }

    fun getPlanetInDB(planetsData: PlanetData): DBModelPlanets {
        return DBModelPlanets(
            id = getID(planetsData.url),
            name = planetsData.name,
            rotationPeriod = planetsData.rotationPeriod,
            orbitalPeriod = planetsData.orbitalPeriod,
            diameter = planetsData.diameter,
            climate = planetsData.climate,
            gravity = planetsData.gravity,
            terrain = planetsData.terrain,
            surfaceWater = planetsData.surfaceWater,
            population = planetsData.population
        )
    }
}