package com.sun.dogbreeds.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.huma.room_for_asset.RoomAsset
import com.sun.dogbreeds.data.db.dao.BreedDao
import com.sun.dogbreeds.data.db.entity.Breed

private const val DATABASE_NAME = "breeds.db"
private const val DATABASE_VERSION = 2

@Database(entities = [Breed::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun breedDao(): BreedDao

    companion object {

        private var sInstance: AppDatabase? = null

        @JvmStatic
        fun getInstance(context: Context) = sInstance ?: getDatabase(context).also { sInstance = it }

        @JvmStatic
        private fun getDatabase(context: Context): AppDatabase =
            RoomAsset.databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()
    }
}
