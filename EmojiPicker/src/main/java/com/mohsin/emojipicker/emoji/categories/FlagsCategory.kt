package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.FlagsCategoryUnicodes

data class FlagsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<FlagsCategoryUnicodes> = enumValues<FlagsCategoryUnicodes>().toList()
) : Category
