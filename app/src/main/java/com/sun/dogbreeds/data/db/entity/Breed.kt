package com.sun.dogbreeds.data.db.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sun.dogbreeds.data.db.entity.EntityFields.FIELD_ALT_NAME
import com.sun.dogbreeds.data.db.entity.EntityFields.FIELD_DESCRIPTION
import com.sun.dogbreeds.data.db.entity.EntityFields.FIELD_ID
import com.sun.dogbreeds.data.db.entity.EntityFields.FIELD_IMAGE_URL
import com.sun.dogbreeds.data.db.entity.EntityFields.FIELD_NAME
import com.sun.dogbreeds.data.db.entity.EntityFields.FIELD_ORIGIN
import com.sun.dogbreeds.utils.Constants
import kotlinx.android.parcel.Parcelize

@Entity(tableName = Breed.TABLE_NAME)
@Parcelize
data class Breed(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = FIELD_ID) val id: Int = Constants.UNAVAILABLE_VALUE,
    @ColumnInfo(name = FIELD_NAME) val name: String = Constants.NO_INFORMATION,
    @ColumnInfo(name = FIELD_ALT_NAME) val altNames: String? = null,
    @ColumnInfo(name = FIELD_ORIGIN) val origin: String? = null,
    @ColumnInfo(name = FIELD_DESCRIPTION) val description: String? = null,
    @ColumnInfo(name = FIELD_IMAGE_URL) val imageUrl: String? = null
) : Parcelable {

    companion object {
        const val TABLE_NAME = "tbl_breeds"
    }
}
