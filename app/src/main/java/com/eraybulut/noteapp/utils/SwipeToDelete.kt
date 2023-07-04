package com.eraybulut.noteapp.utils

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.eraybulut.noteapp.R
import com.eraybulut.noteapp.ui.home.NoteAdapter

class SwipeToDeleteCallback(private val adapter: NoteAdapter) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.RIGHT) adapter.deleteNote(viewHolder.adapterPosition)
        if (direction == ItemTouchHelper.LEFT) adapter.shareNote(viewHolder.adapterPosition)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val itemView = viewHolder.itemView

        val iconDelete = ContextCompat.getDrawable(itemView.context, R.drawable.img_delete)
        val background = GradientDrawable()
        background.shape = GradientDrawable.RECTANGLE
        background.cornerRadius = 30f
        background.setColor(Color.parseColor("#FF0000"))

        val iconMargin = (itemView.height - iconDelete!!.intrinsicHeight) / 4
        val iconTop = itemView.top + (itemView.height - iconDelete.intrinsicHeight) / 2
        val iconBottom = iconTop + iconDelete.intrinsicHeight

        val iconShare = ContextCompat.getDrawable(itemView.context, R.drawable.img_share)
        val backgroundShare = GradientDrawable()
        backgroundShare.shape = GradientDrawable.RECTANGLE
        backgroundShare.cornerRadius = 30f
        backgroundShare.setColor(Color.parseColor("#2196F3"))

        if (dX > 0) {
            val iconLeft = itemView.left + iconMargin
            val iconRight = itemView.left + iconMargin + iconDelete.intrinsicWidth
            iconDelete.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            background.setBounds(itemView.left, itemView.top, itemView.left + dX.toInt(), itemView.bottom)
        } else {
            val iconLeft = itemView.right - iconMargin - iconShare!!.intrinsicWidth
            val iconRight = itemView.right - iconMargin
            iconShare.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            backgroundShare.setBounds(itemView.right + dX.toInt(), itemView.top, itemView.right, itemView.bottom)
        }

        background.draw(c)
        iconDelete.draw(c)

        backgroundShare.draw(c)
        iconShare?.draw(c)


        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}
