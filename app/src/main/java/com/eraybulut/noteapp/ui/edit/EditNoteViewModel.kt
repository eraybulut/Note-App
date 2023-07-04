package com.eraybulut.noteapp.ui.edit

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eraybulut.noteapp.data.local.NoteDatabase
import com.eraybulut.noteapp.data.repository.NoteRepository
import com.eraybulut.noteapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor (private val noteRepository: NoteRepository): ViewModel() {

    fun deleteNote(note : Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note = note)
        }
    }

    fun updateNote(note : Note){
        viewModelScope.launch {
            noteRepository.updateNote(note = note)
        }
    }
}