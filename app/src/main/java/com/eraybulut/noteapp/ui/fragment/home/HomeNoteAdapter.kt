package com.eraybulut.noteapp.ui.fragment.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.databinding.ItemNoteBinding
import com.eraybulut.noteapp.model.Note

class HomeNoteAdapter :RecyclerView.Adapter<HomeNoteAdapter.CardViewHolder>() {

    private var noteList = emptyList<Note>()

    private var selected = 0
    class CardViewHolder(private val binding : ItemNoteBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(note : Note){
            binding.currentNote = note
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNoteBinding.inflate(layoutInflater, parent, false)
                return CardViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder = CardViewHolder.from(parent)

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind(note = noteList[position])

    override fun getItemCount(): Int = noteList.size


    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList : List<Note>){
        this.noteList = newList
        notifyDataSetChanged()
    }
}