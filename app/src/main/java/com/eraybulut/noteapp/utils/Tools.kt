package com.eraybulut.noteapp.utils

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
}