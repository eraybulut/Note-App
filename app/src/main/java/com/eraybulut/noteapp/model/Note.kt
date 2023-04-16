package com.eraybulut.noteapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eraybulut.noteapp.utils.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val title : String,
    val note : String,
    val mood : String,
    val date : String
)