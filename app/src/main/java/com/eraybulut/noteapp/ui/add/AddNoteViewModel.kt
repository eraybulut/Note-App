package com.eraybulut.noteapp.ui.add

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.eraybulut.noteapp.common.BaseViewModel
import com.eraybulut.noteapp.data.local.NoteDatabase
import com.eraybulut.noteapp.data.repository.NoteRepository
import com.eraybulut.noteapp.model.Note
import kotlinx.coroutines.launch

class AddNoteViewModel(application: Application) : BaseViewModel(application) {

    private val noteRepository : NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        noteRepository = NoteRepository(noteDao)
    }

    fun addNote(note: Note){
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

}