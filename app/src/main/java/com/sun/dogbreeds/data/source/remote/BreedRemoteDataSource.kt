package com.sun.dogbreeds.data.source.remote

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.coroutine.awaitResult
import com.sun.dogbreeds.data.api.DogCeoApi
import com.sun.dogbreeds.data.api.response.DogCeoResponse
import com.sun.dogbreeds.data.source.BreedDataSource

class BreedRemoteDataSource(private val dogCeoApi: DogCeoApi) : BreedDataSource.Remote {

    override suspend fun getBreedImageUrls(breedName: String): CoroutineResult<DogCeoResponse> =
        dogCeoApi.getImagesAsync(breedName).awaitResult()
}
