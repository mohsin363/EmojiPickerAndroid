package com.mohsin.emojipicker.view.recyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.nio.charset.StandardCharsets

@Parcelize
data class EmojiItemView(val unicode: String, val type: EmojiItemType = EmojiItemType.EMOJI, val name: String? = null): Parcelable {
    companion object {
        fun createEmojiViewItem(unicode: ByteArray, unicodeName: String): EmojiItemView {
            return EmojiItemView(unicode.toAscii(), EmojiItemType.EMOJI, unicodeName)
        }
    }
}

enum class EmojiItemType {
    EMOJI
}

fun ByteArray.toAscii(): String {
    return String(this, StandardCharsets.UTF_8)
}
