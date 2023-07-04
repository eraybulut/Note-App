package com.eraybulut.noteapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eraybulut.noteapp.data.repository.NoteRepository
import com.eraybulut.noteapp.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    init {
        readAllData()
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note = note)
    }

    fun readAllData(): Flow<List<Note>> = flow {
        emit(noteRepository.readAllNote())
    }
}