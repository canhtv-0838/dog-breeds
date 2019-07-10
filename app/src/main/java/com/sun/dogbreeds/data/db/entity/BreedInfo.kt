package com.sun.dogbreeds.data.db.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

private const val FIELD_ID = "id"
private const val FIELD_NAME = "name"
private const val FIELD_ALT_NAME = "altName"
private const val FIELD_IMAGE_URL = "imageUrl"

@Entity(tableName = BreedInfo.TABLE_NAME)
@Parcelize
data class BreedInfo(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = FIELD_ID) val id: Int,
    @ColumnInfo(name = FIELD_NAME) val name: String,
    @ColumnInfo(name = FIELD_ALT_NAME) val altName: String? = null,
    @ColumnInfo(name = FIELD_IMAGE_URL) val imageUrl: String? = null
): Parcelable{

    companion object {
        const val TABLE_NAME = "tbl_favorites"
    }
}
