package com.sun.dogbreeds.data.api.response

import com.google.gson.annotations.SerializedName

data class DogCeoResponse(
    @SerializedName(DogCeoJsonKeys.MESSAGE) val message: List<String>,
    @SerializedName(DogCeoJsonKeys.STATUS) val status: String
)
