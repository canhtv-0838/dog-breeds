package com.sun.dogbreeds.data.api

import com.sun.dogbreeds.BuildConfig
import com.sun.dogbreeds.data.api.response.TheDogApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val ENDPOINT_BREEDS_SEARCH = "v1/breeds/search"
private const val QUERY_Q = "q"

interface TheDogApi {

    @Headers(BuildConfig.HEADERS_X_API_KEY)
    @GET(ENDPOINT_BREEDS_SEARCH)
    fun getBreedByNameAsync(@Query(QUERY_Q) q: String): Deferred<List<TheDogApiResponse>>

    companion object {
        const val BASE_URL = "https://api.thedogapi.com"
    }
}
