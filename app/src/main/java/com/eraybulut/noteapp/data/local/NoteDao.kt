package com.eraybulut.noteapp.data.local

import androidx.room.*
import com.eraybulut.noteapp.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note : Note)

    @Query("SELECT * FROM note_table")
    suspend fun readAllNote() : List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}