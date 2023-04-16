package com.eraybulut.noteapp.ui.fragment.home

import android.app.Application
import androidx.lifecycle.LiveData
import com.eraybulut.noteapp.common.BaseViewModel
import com.eraybulut.noteapp.data.local.NoteDatabase
import com.eraybulut.noteapp.data.repository.NoteRepository
import com.eraybulut.noteapp.model.Note

class HomeFragmentViewModel(application: Application) : BaseViewModel(application)  {

    val readAllData: LiveData<List<Note>>
    private val noteRepository : NoteRepository

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        noteRepository = NoteRepository(noteDao)
        readAllData = noteRepository.readAllNote
    }
}