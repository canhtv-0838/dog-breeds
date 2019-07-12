package com.sun.dogbreeds.data.repsitory

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.api.response.DogCeoResponse
import com.sun.dogbreeds.data.source.BreedDataSource

class BreedRemoteRepository(private val dataSource: BreedDataSource.Remote) : BreedDataSource.Remote {

    override suspend fun getBreedImageUrls(breedName: String): CoroutineResult<DogCeoResponse> =
        dataSource.getBreedImageUrls(breedName)
}
