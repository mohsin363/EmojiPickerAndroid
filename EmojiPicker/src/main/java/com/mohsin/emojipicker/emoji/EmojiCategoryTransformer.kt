package com.mohsin.emojipicker.emoji

import android.os.Build
import com.mohsin.emojipicker.emoji.categories.Category
import com.mohsin.emojipicker.emoji.categoryUnicodes.EmojiData
import com.mohsin.emojipicker.view.recyclerview.EmojiItemView

class EmojiCategoryTransformer {

    fun transform(category: Category): List<EmojiItemView> = transformCategoryToEmojiItems(category).filter {
        //EmojiCompatUtils.hasEmojiGlyph(it.unicode)
        true
    }

    fun transform(list: Array<ArrayList<String>>): List<ArrayList<String>> {
        val transformList = mutableListOf<ArrayList<String>>()
        val transform = mutableListOf<String>()
        for (i in list.indices) {
            if (i == 7) {
                when (Build.VERSION.SDK_INT) {
                    Build.VERSION_CODES.M -> transform.addAll(getGlyphEnabledList(list[i]).filter {
                        !EmojiData.missingEmojis24.contains(
                            it
                        )
                    })

                    Build.VERSION_CODES.N -> transform.addAll(getGlyphEnabledList(list[i]).filter {
                        !EmojiData.missingEmojis24.contains(
                            it
                        )
                    })

                    Build.VERSION_CODES.N_MR1 -> transform.addAll(getGlyphEnabledList(list[i]).filter {
                        !EmojiData.missingEmojis25.contains(
                            it
                        )
                    })

                    Build.VERSION_CODES.O, Build.VERSION_CODES.O_MR1 -> transform.addAll(
                        getGlyphEnabledList(list[i]).filter { !EmojiData.missingEmojis26.contains(it) })

                    else -> {
                        transform.addAll(getGlyphEnabledList(list[i]).filter {
                            !EmojiData.EmojisWithoutAliases.contains(
                                it
                            )
                        })
                    }
                }
            } else {
                transform.addAll(getGlyphEnabledList(list[i]).filter { !EmojiData.EmojisWithoutAliases.contains(it) })
            }

            transformList.add(ArrayList(transform))
            transform.clear()
        }
        return transformList
    }

    private fun getGlyphEnabledList(emojiList: ArrayList<String>): List<String> {
        val transformedList = mutableListOf<String>()
        for (emoji in emojiList) {
            if (EmojiCompatUtils.hasEmojiGlyph(emoji)) {
                transformedList.add(emoji)
            }
        }
        return transformedList
    }

    private fun transformCategoryToEmojiItems(category: Category): List<EmojiItemView> {
        val list: MutableList<EmojiItemView> = mutableListOf()

        list.apply {
            category.categoryUnicode.forEach {
                list.add(EmojiItemView.createEmojiViewItem(it.unicode, it.name))
            }
        }

        return list
    }
}
