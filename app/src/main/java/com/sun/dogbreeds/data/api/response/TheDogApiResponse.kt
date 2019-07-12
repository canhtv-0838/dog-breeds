package com.sun.dogbreeds.data.api.response

import com.google.gson.annotations.SerializedName
import com.sun.dogbreeds.utils.Constants

data class TheDogApiResponse(
    @SerializedName(TheDogApiJsonKeys.WEIGHT) val weight: Weight,
    @SerializedName(TheDogApiJsonKeys.HEIGHT) val height: Height,
    @SerializedName(TheDogApiJsonKeys.ID) val id: Int = Constants.UNAVAILABLE_VALUE,
    @SerializedName(TheDogApiJsonKeys.NAME) val name: String = Constants.NO_INFORMATION,
    @SerializedName(TheDogApiJsonKeys.BREED_FOR) val breedFor: String? = Constants.NO_INFORMATION,
    @SerializedName(TheDogApiJsonKeys.BREED_GROUP) val breedGroup: String? = Constants.NO_INFORMATION,
    @SerializedName(TheDogApiJsonKeys.LIFE_SPAN) val lifeSpan: String? = Constants.NO_INFORMATION,
    @SerializedName(TheDogApiJsonKeys.TEMPERAMENT) val temperament: String? = Constants.NO_INFORMATION
) {
    data class Weight(
        @SerializedName(TheDogApiJsonKeys.IMPERIAL) val imperial: String = Constants.NO_INFORMATION,
        @SerializedName(TheDogApiJsonKeys.METRIC) val metric: String = Constants.NO_INFORMATION
    ) {
        fun getInfo(): String = StringBuilder()
            .append("Imperial: ").append(imperial).append("; ")
            .append("Metric: ").append(metric)
            .toString()
    }

    data class Height(
        @SerializedName(TheDogApiJsonKeys.IMPERIAL) val imperial: String = Constants.NO_INFORMATION,
        @SerializedName(TheDogApiJsonKeys.METRIC) val metric: String = Constants.NO_INFORMATION
    ) {
        fun getInfo(): String = StringBuilder()
            .append("Imperial: ").append(imperial).append("; ")
            .append("Metric: ").append(metric)
            .toString()
    }
}
