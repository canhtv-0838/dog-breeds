package com.sun.dogbreeds.data.api.response

import com.google.gson.annotations.SerializedName
import com.sun.dogbreeds.utils.Constants

data class DogCeoResponse(
    @SerializedName(DogCeoJsonKeys.MESSAGE) val message: List<String> = emptyList(),
    @SerializedName(DogCeoJsonKeys.STATUS) val status: String = Constants.NO_INFORMATION
)
