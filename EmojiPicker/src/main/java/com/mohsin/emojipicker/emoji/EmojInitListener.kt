package com.mohsin.emojipicker.emoji

interface EmojiInitListener {
    fun onEmojisInitialized(isInitialized: Boolean, throwable: Throwable? = null)
}
