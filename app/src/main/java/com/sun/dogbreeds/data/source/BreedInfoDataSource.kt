package com.sun.dogbreeds.data.source

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.api.response.TheDogApiResponse

interface BreedInfoDataSource {

    interface Remote{
        suspend fun getBreedInfo(name: String): CoroutineResult<List<TheDogApiResponse>>
    }
}
