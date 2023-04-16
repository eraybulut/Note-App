package com.eraybulut.noteapp.utils.extensions


fun String.truncate(length: Int, truncateIndicator: String = "..."): String {
    return if (this.length > length) {
        this.substring(0, length - truncateIndicator.length) + truncateIndicator
    } else {
        this
    }
}