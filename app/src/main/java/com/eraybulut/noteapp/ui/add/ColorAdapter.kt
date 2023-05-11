package com.eraybulut.noteapp.ui.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.databinding.ItemColorBinding
import com.eraybulut.noteapp.utils.extensions.onClick
import com.eraybulut.noteapp.utils.extensions.setTintColor

/** Code With 💚
 * Created by Eray BULUT on 11.05.2023
 * eraybulutlar@gmail.com
 */
class ColorAdapter(
    private val colorArrayList : ArrayList<Int>,
    private val listener: ColorItemClickListener
) : RecyclerView.Adapter<ColorAdapter.CardViewHolder>() {


    private var selected = 0
    inner class CardViewHolder(private val binding : ItemColorBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(listener: ColorItemClickListener, color : Int, position: Int){

            binding.colorCircle.setTintColor(color)


            if (selected == position)binding.selectedRoot.setTintColor(R.color.black)
            else binding.selectedRoot.setTintColor(R.color.white)

            binding.selectedRoot.onClick {
                listener.onColorItemClick(color)
                selected = adapterPosition
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder = CardViewHolder(ItemColorBinding.inflate(
        LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) = holder.bind(listener = listener, color = colorArrayList[position], position = position)

    override fun getItemCount(): Int = colorArrayList.size
}
