package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.SymbolsCategoryUnicodes

data class SymbolsCategory(
    override val categoryName: String,
    override val categoryUnicode: List<SymbolsCategoryUnicodes> = enumValues<SymbolsCategoryUnicodes>().toList()
) : Category
