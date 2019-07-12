package com.sun.dogbreeds.data.source.remote

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.coroutine.awaitResult
import com.sun.dogbreeds.data.api.TheDogApi
import com.sun.dogbreeds.data.api.response.TheDogApiResponse
import com.sun.dogbreeds.data.source.BreedInfoDataSource

class BreedInfoRemoteDataSource(private val theDogApi: TheDogApi) : BreedInfoDataSource.Remote {

    override suspend fun getBreedInfo(name: String): CoroutineResult<List<TheDogApiResponse>> =
        theDogApi.getBreedByNameAsync(q = name).awaitResult()
}
