package com.eraybulut.noteapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eraybulut.noteapp.utils.Constants.TABLE_NAME
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val note : String,
    val mood : String,
    val date : String,
    val backgroundColor : Int
) : Parcelable