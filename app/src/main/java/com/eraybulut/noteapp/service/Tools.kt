package com.eraybulut.noteapp.service

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import java.text.SimpleDateFormat
import java.util.*

class Tools {

    @SuppressLint("SimpleDateFormat")
    fun currentTime(): String {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(time)
    }

    fun shareText(context: Context, text : String){
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_TEXT,text)
        shareIntent.type = "text/plain"
        context.startActivity(shareIntent)
    }
}