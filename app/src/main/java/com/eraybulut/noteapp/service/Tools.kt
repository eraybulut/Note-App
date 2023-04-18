package com.eraybulut.noteapp.service

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import com.eraybulut.noteapp.model.Note
import java.text.SimpleDateFormat
import java.util.*

class Tools {

    @SuppressLint("SimpleDateFormat")
    fun currentTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(time)
    }

    fun shareText(context: Context,note : Note){
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_TEXT,"${note.title}\n${note.note} \nTarihinde kaydedilmiştir${note.date}")
        shareIntent.type = "text/plain"
        context.startActivity(shareIntent)
    }
}