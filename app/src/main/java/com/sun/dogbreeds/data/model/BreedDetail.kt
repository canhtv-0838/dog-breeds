package com.sun.dogbreeds.data.model

import com.sun.dogbreeds.data.api.response.TheDogApiResponse
import com.sun.dogbreeds.utils.Constants

data class BreedDetail(
    val name: String = Constants.TITLE_LOADING,
    val weight: String = Constants.TITLE_LOADING,
    val height: String = Constants.TITLE_LOADING,
    val lifeSpan: String = Constants.TITLE_LOADING,
    val breedFor: String = Constants.TITLE_LOADING,
    val breedGroup: String = Constants.TITLE_LOADING,
    val temperament: String = Constants.TITLE_LOADING
) {
    constructor(response: TheDogApiResponse) : this(
        name = response.name,
        weight = response.weight.getInfo(),
        height = response.height.getInfo(),
        lifeSpan = response.lifeSpan ?: Constants.NO_INFORMATION,
        breedFor = response.breedFor ?: Constants.NO_INFORMATION,
        breedGroup = response.breedFor ?: Constants.NO_INFORMATION,
        temperament = response.temperament ?: Constants.NO_INFORMATION
    )
}
