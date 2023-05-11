package com.eraybulut.noteapp.utils.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat


fun View.visibly(){
    this.visibility = View.VISIBLE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun EditText.getTextString() : String{
    return text.toString().trim()
}

fun View.onClick(onClick: (View) -> Unit) {
    setOnClickListener(onClick)
}

fun View.setTintColor(@ColorRes colorRes: Int){
    background.setTint(ContextCompat.getColor(context,colorRes))
}

fun View.setBackgroundColorRes(@ColorRes colorRes: Int) {
    setBackgroundColor(ContextCompat.getColor(context, colorRes))
}
fun View.setBackgroundRes(@DrawableRes res :Int) {
    background = ContextCompat.getDrawable(this.context,res)
}

fun TextView.setTextColorRes(@ColorRes colorRes: Int) {
    setTextColor(ContextCompat.getColor(context, colorRes))
}

fun TextView.getDrawableCompat(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(context, id)
}
