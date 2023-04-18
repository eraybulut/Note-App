package com.eraybulut.noteapp.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.eraybulut.noteapp.common.BaseViewModel
import com.eraybulut.noteapp.data.local.NoteDatabase
import com.eraybulut.noteapp.data.repository.NoteRepository
import com.eraybulut.noteapp.model.Note
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application) : BaseViewModel(application)  {

    val readAllData: LiveData<List<Note>>
    private val noteRepository : NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        noteRepository = NoteRepository(noteDao)
        readAllData = noteRepository.readAllNote
    }


    fun deleteNote(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note = note)
        }
    }
}