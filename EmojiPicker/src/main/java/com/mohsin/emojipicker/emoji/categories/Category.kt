package com.mohsin.emojipicker.emoji.categories

import com.mohsin.emojipicker.emoji.categoryUnicodes.CategoryUnicodes

interface Category {
    val categoryName: String
    val categoryUnicode: List<CategoryUnicodes>
}
