package com.sun.dogbreeds.data.db.dao

import androidx.room.*
import com.sun.dogbreeds.data.db.entity.BreedInfo

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(breedInfo: BreedInfo)

    @Delete
    suspend fun remove(breedInfo: BreedInfo)

    @Query("SELECT * FROM ${BreedInfo.TABLE_NAME}")
    suspend fun getFavorites(): List<BreedInfo>?
}
