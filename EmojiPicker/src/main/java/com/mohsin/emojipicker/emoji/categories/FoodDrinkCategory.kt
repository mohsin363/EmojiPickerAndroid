package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.FoodDrinkCategoryUnicodes

data class FoodDrinkCategory(
    override val categoryName: String,
    override val categoryUnicode: List<FoodDrinkCategoryUnicodes> = enumValues<FoodDrinkCategoryUnicodes>().toList()
) : Category
