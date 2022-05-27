package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.SmileysPeopleCategoryUnicodes

data class SmileysPeopleCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SmileysPeopleCategoryUnicodes> = enumValues<SmileysPeopleCategoryUnicodes>().toList()
) : Category