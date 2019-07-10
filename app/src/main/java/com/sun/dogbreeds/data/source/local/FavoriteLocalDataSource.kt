package com.sun.dogbreeds.data.source.local

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.AppDatabase
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.data.source.DataDeleteFailed
import com.sun.dogbreeds.data.source.DataInsertFailed
import com.sun.dogbreeds.data.source.DataNotAvailableException
import com.sun.dogbreeds.data.source.FavoriteDataSource

class FavoriteLocalDataSource(private val appDatabase: AppDatabase) : FavoriteDataSource {

    override suspend fun addFavorite(breedInfo: BreedInfo): CoroutineResult<BreedInfo> = try {
        appDatabase.favoriteDao().add(breedInfo)
        CoroutineResult.Success(breedInfo)
    } catch (e: Exception) {
        CoroutineResult.Error(DataInsertFailed())
    }

    override suspend fun removeFavorite(breedInfo: BreedInfo): CoroutineResult<BreedInfo> = try {
        appDatabase.favoriteDao().remove(breedInfo)
        CoroutineResult.Success(breedInfo)
    } catch (e: Exception) {
        CoroutineResult.Error(DataDeleteFailed())
    }

    override suspend fun getFavorites(): CoroutineResult<List<BreedInfo>> {
        val resultData = appDatabase.favoriteDao().getFavorites()
        return resultData?.let {
            CoroutineResult.Success(it)
        } ?: CoroutineResult.Error(DataNotAvailableException())
    }
}
