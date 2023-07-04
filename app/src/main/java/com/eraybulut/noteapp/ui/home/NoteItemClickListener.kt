package com.eraybulut.noteapp.ui.home

import com.eraybulut.noteapp.model.Note

interface NoteItemClickListener {
    fun onItemClick(note : Note)
    fun onDeleteItem(note: Note,position :Int)
    fun onShareItem(note: Note)
}