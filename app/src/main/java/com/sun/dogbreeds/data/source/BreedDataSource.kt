package com.sun.dogbreeds.data.source

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.entity.Breed

interface BreedDataSource {

    interface Local{
        suspend fun getBreeds(): CoroutineResult<List<Breed>>
    }

    interface Remote{
    }
}
