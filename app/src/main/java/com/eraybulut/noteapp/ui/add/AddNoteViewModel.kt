package com.eraybulut.noteapp.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eraybulut.noteapp.data.repository.NoteRepository
import com.eraybulut.noteapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor (private val noteRepository :NoteRepository) : ViewModel(){

    fun addNote(note: Note) = viewModelScope.launch{
       noteRepository.addNote(note)
    }
}