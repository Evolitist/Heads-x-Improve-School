package com.evolitist.swapi.mapper

import com.evolitist.swapi.db.model.PersonDbModel
import com.evolitist.swapi.network.model.PersonApiModel
import com.evolitist.swapi.ui.model.Person

object SWMapper {

    fun apiToDbModel(apiModel: PersonApiModel) = PersonDbModel(
        id = apiModel.url.split("/").last { it.isNotEmpty() }.toInt(),
        name = apiModel.name,
        height = apiModel.height,
        mass = apiModel.mass,
        hairColor = apiModel.hairColor,
        skinColor = apiModel.skinColor,
        eyeColor = apiModel.eyeColor,
        birthYear = apiModel.birthYear,
        gender = apiModel.gender,
    )

    fun dbToUiModel(dbEntity: PersonDbModel) = Person(
        id = dbEntity.id,
        name = dbEntity.name,
        height = dbEntity.height,
        mass = dbEntity.mass,
        hairColor = dbEntity.hairColor,
        skinColor = dbEntity.skinColor,
        eyeColor = dbEntity.eyeColor,
        birthYear = dbEntity.birthYear,
        gender = dbEntity.gender,
    )
}
