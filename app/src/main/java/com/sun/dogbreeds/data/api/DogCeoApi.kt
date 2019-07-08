package com.sun.dogbreeds.data.api

import com.sun.dogbreeds.data.api.response.DogCeoResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

private const val PATH_BREED_NAME = "breedName"
private const val ENDPOINT_IMAGES = "api/breed/{$PATH_BREED_NAME}/images"

interface DogCeoApi {

    @GET(ENDPOINT_IMAGES)
    fun getImagesAsync(@Path(PATH_BREED_NAME) breedName: String): Deferred<DogCeoResponse>

    companion object {
        const val BASE_URL = "https://dog.ceo"
    }
}
