package com.sun.dogbreeds.data.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val FIELD_ID = "id"
private const val FIELD_NAME = "name"
private const val FIELD_ALT_NAMES = "altNames"
private const val FIELD_ORIGIN = "origin"
private const val FIELD_DESCRIPTION = "description"
private const val FIELD_IMAGE_URL = "imageUrl"

@Entity(tableName = Breed.TABLE_NAME)
data class Breed(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = FIELD_ID) val id: Int,
    @ColumnInfo(name = FIELD_NAME) val name: String,
    @ColumnInfo(name = FIELD_ALT_NAMES) val altNames: String? = null,
    @ColumnInfo(name = FIELD_ORIGIN) val origin: String? = null,
    @ColumnInfo(name = FIELD_DESCRIPTION) val description: String? = null,
    @ColumnInfo(name = FIELD_IMAGE_URL) val imageUrl: String? = null
) {
    companion object {
        const val TABLE_NAME = "tbl_create_breeds"
    }
}
