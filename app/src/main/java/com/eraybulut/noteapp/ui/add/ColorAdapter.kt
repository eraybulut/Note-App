package com.eraybulut.noteapp.ui.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.databinding.ItemColorBinding
import com.eraybulut.noteapp.utils.extensions.setTintColor

/** Code With 💚
 * Created by Eray BULUT on 11.05.2023
 * eraybulutlar@gmail.com
 */
class ColorAdapter(
    private val listener: ColorItemClickListener
) : RecyclerView.Adapter<ColorAdapter.CardViewHolder>() {

    private var colorList = emptyList<Int>()
    private var selected = 0
    inner class CardViewHolder(private val binding : ItemColorBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind( color : Int, position: Int){

            binding.colorCircle.setTintColor(color)

            if (selected == position)binding.selectedRoot.setTintColor(R.color.black)
            else binding.selectedRoot.setTintColor(R.color.white)

            binding.selectedRoot.setOnClickListener {
                listener.onColorItemClick(color)
                selected = adapterPosition
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder = CardViewHolder(ItemColorBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind(color = colorList[position], position = position)

    override fun getItemCount(): Int = colorList.size

    fun addColorList(newColorList: List<Int>){
        colorList = newColorList
        notifyDataSetChanged()
    }
}
