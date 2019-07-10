package com.sun.dogbreeds.data.source

import com.sun.dogbreeds.coroutine.CoroutineResult
import com.sun.dogbreeds.data.db.entity.BreedInfo

interface FavoriteDataSource {

    suspend fun addFavorite(breedInfo: BreedInfo): CoroutineResult<BreedInfo>

    suspend fun removeFavorite(breedInfo: BreedInfo): CoroutineResult<BreedInfo>

    suspend fun getFavorites(): CoroutineResult<List<BreedInfo>>
}
