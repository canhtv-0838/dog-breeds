package com.sun.dogbreeds.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.sun.dogbreeds.data.db.entity.Breed

@Dao
interface BreedDao {

    @Query("SELECT * FROM ${Breed.TABLE_NAME}")
    suspend fun getBreeds(): List<Breed>?
}
