package com.sun.dogbreeds.data.repsitory

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.entity.Breed
import com.sun.dogbreeds.data.source.BreedDataSource

class BreedsLocalRepository(private val localDataSource: BreedDataSource.Local) : BreedDataSource.Local {

    override suspend fun getBreeds(): CoroutineResult<List<Breed>> = localDataSource.getBreeds()
}
