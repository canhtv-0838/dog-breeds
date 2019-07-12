package com.sun.dogbreeds.data.repsitory

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.api.response.TheDogApiResponse
import com.sun.dogbreeds.data.source.BreedInfoDataSource

class BreedInfoRepository(private val dataSource: BreedInfoDataSource.Remote) : BreedInfoDataSource.Remote {

    override suspend fun getBreedInfo(name: String): CoroutineResult<List<TheDogApiResponse>> =
        dataSource.getBreedInfo(name = name)
}
