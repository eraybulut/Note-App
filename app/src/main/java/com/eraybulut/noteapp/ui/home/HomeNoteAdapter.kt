package com.eraybulut.noteapp.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.databinding.ItemNoteBinding
import com.eraybulut.noteapp.model.Note

class HomeNoteAdapter(
    private val listener: NoteItemClickListener
) : RecyclerView.Adapter<HomeNoteAdapter.CardViewHolder>() {

    private var noteList = ArrayList<Note>()

    inner class CardViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: NoteItemClickListener, note: Note) {
            binding.onClickItem = listener
            binding.currentNote = note
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) =
        holder.bind(listener = listener, note = noteList[position])

    override fun getItemCount(): Int = noteList.size


    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: ArrayList<Note>) {
        this.noteList.clear()
        this.noteList = newList
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        listener.onDeleteItem(noteList[position])
        this.noteList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun shareNote(position: Int){
        listener.onShareItem(noteList[position])
    }
}