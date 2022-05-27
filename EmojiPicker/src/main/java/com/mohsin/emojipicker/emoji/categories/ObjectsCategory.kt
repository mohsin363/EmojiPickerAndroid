package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.ObjectsCategoryUnicodes

data class ObjectsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<ObjectsCategoryUnicodes> = enumValues<ObjectsCategoryUnicodes>().toList()
) : Category
