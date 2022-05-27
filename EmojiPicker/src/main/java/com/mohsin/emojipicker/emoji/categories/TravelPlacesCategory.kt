package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.TravelPlacesCategoryUnicodes

data class TravelPlacesCategory(
    override val categoryName: String,
    override val categoryUnicode: List<TravelPlacesCategoryUnicodes> = enumValues<TravelPlacesCategoryUnicodes>().toList()
) : Category
