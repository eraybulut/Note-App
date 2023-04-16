package com.eraybulut.noteapp.ui.fragment.add

import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.databinding.ItemModeBinding

class ModeAdapter(
    private val modeList: ArrayList<String>,
    private val listener: ModeItemClickListener
) : RecyclerView.Adapter<ModeAdapter.CardViewHolder>(){


    class CardViewHolder(private val binding : ItemModeBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(listener: ModeItemClickListener,mode : String){
            binding.onItemClickListener = listener
            binding.currentMode = mode
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup) : CardViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemModeBinding.inflate(layoutInflater,parent,false)
                return CardViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder = CardViewHolder.from(parent)

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind(listener = listener,modeList[position])

    override fun getItemCount(): Int = modeList.size
}
