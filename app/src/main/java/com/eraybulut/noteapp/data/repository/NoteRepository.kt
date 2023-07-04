package com.eraybulut.noteapp.data.repository

import com.eraybulut.noteapp.data.local.NoteDao
import com.eraybulut.noteapp.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun readAllNote(): List<Note> {
        return noteDao.readAllNote()
    }

    suspend fun addNote(note: Note) {
        noteDao.addNote(note = note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.updateNote(note = note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note = note)
    }
}