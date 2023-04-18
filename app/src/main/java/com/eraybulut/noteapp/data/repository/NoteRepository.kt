package com.eraybulut.noteapp.data.repository

import androidx.lifecycle.LiveData
import com.eraybulut.noteapp.data.local.NoteDao
import com.eraybulut.noteapp.model.Note

class NoteRepository(private val noteDao: NoteDao) {

    val readAllNote : LiveData<List<Note>> = noteDao.readAllNote()

    suspend fun addNote(note: Note){
        noteDao.addNote(note = note)
    }

    suspend fun updateNote(note: Note){
        noteDao.updateNote(note = note)
    }

    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note = note)
    }
}