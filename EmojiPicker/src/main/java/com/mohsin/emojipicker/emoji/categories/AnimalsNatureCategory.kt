package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.AnimalsNatureCategoryUnicodes

data class AnimalsNatureCategory(
    override val categoryName: String,
    override val categoryUnicode: List<AnimalsNatureCategoryUnicodes> = enumValues<AnimalsNatureCategoryUnicodes>().toList()
) : Category
