package com.sun.dogbreeds.data.repsitory

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.entity.BreedInfo
import com.sun.dogbreeds.data.source.FavoriteDataSource

class FavoriteRepository(private val dataSource: FavoriteDataSource) : FavoriteDataSource {

    override suspend fun addFavorite(breedInfo: BreedInfo): CoroutineResult<BreedInfo> =
        dataSource.addFavorite(breedInfo)

    override suspend fun removeFavorite(breedInfo: BreedInfo): CoroutineResult<BreedInfo> =
        dataSource.removeFavorite(breedInfo)

    override suspend fun getFavorites(): CoroutineResult<List<BreedInfo>> = dataSource.getFavorites()
}
