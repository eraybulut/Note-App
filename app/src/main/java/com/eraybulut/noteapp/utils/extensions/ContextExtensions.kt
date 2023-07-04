package com.eraybulut.noteapp.utils.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.eraybulut.noteapp.model.Note


fun Context.showToast(message :String, duration :Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.shareText(note : Note){
    Intent(Intent.ACTION_SEND).apply {
        putExtra(Intent.EXTRA_TEXT, "${note.title}\n${note.note} \nTarihinde kaydedilmiştir${note.date}")
        type = "text/plain"
    }.also { intent ->
        startActivity(intent)
    }
}