package com.eraybulut.noteapp.ui.add


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.databinding.ItemModeBinding
import com.eraybulut.noteapp.utils.extensions.setBackgroundRes

class ModeAdapter : RecyclerView.Adapter<ModeAdapter.CardViewHolder>(){

    private var selected = -1
    private var modeList = emptyList<String>()
    private var onSelectListener : ((String) -> Unit)? = null
    inner class CardViewHolder(private val binding : ItemModeBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(mode : String, position: Int){
            binding.currentMode = mode
            binding.executePendingBindings()

           if(selected == position) binding.itemMode.setBackgroundRes(R.drawable.rounded_orange_border_10)
           else binding.itemMode.setBackgroundRes(R.drawable.rounded_gray_border_10)

            binding.itemMode.setOnClickListener{
                onSelectListener?.invoke(mode)
                selected = adapterPosition
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardViewHolder(ItemModeBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind(mode = modeList[position],position = position)

    override fun getItemCount(): Int = modeList.size

    fun addModeList(newModeList : List<String>){
        modeList = newModeList
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener : ((String) -> Unit)){
        onSelectListener = listener
    }
}
