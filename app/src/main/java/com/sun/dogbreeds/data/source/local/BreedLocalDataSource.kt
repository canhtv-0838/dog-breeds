package com.sun.dogbreeds.data.source.local

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.AppDatabase
import com.sun.dogbreeds.data.db.entity.Breed
import com.sun.dogbreeds.data.source.BreedDataSource
import com.sun.dogbreeds.data.source.DataNotAvailableException
import kotlinx.coroutines.Dispatchers

class BreedLocalDataSource(private val appDatabase: AppDatabase) : BreedDataSource.Local {

    override suspend fun getBreeds(): CoroutineResult<List<Breed>> {

        val resultData = appDatabase.breedDao().getBreeds()
        return resultData?.let {
            CoroutineResult.Success(it)
        } ?: CoroutineResult.Error(DataNotAvailableException())
    }
}
