package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.ActivityCategoryUnicodes

data class ActivitiesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<ActivityCategoryUnicodes> = enumValues<ActivityCategoryUnicodes>().toList()
) : Category
