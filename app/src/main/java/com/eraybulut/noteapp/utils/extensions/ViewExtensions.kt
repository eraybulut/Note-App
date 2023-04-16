package com.eraybulut.noteapp.utils.extensions

import android.view.View
import android.widget.EditText


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