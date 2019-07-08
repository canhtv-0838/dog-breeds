package com.sun.dogbreeds.data.api.response

import com.google.gson.annotations.SerializedName

data class TheDogApiResponse(
    @SerializedName(TheDogApiJsonKeys.WEIGHT) val weight: Weight,
    @SerializedName(TheDogApiJsonKeys.HEIGHT) val height: Height,
    @SerializedName(TheDogApiJsonKeys.ID) val id: Int,
    @SerializedName(TheDogApiJsonKeys.NAME) val name: String,
    @SerializedName(TheDogApiJsonKeys.BREED_FOR) val breedFor: String?,
    @SerializedName(TheDogApiJsonKeys.BREED_GROUP) val breedGroup: String?,
    @SerializedName(TheDogApiJsonKeys.LIFE_SPAN) val lifeSpan: String?,
    @SerializedName(TheDogApiJsonKeys.TEMPERAMENT) val temperament: String?
) {
    data class Weight(
        @SerializedName(TheDogApiJsonKeys.IMPERIAL) val imperial: String,
        @SerializedName(TheDogApiJsonKeys.METRIC) val metric: String
    ) {
        fun getInfo(): String = StringBuilder()
            .append("Imperial: ").append(imperial).append("; ")
            .append("Metric: ").append(metric)
            .toString()
    }

    data class Height(
        @SerializedName(TheDogApiJsonKeys.IMPERIAL) val imperial: String,
        @SerializedName(TheDogApiJsonKeys.METRIC) val metric: String
    ) {
        fun getInfo(): String = StringBuilder()
            .append("Imperial: ").append(imperial).append("; ")
            .append("Metric: ").append(metric)
            .toString()
    }
}
