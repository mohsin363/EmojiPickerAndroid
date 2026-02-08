package com.mohsin.emojipicker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator
import com.mohsin.emojipicker.R
import com.mohsin.emojipicker.databinding.ViewEmojiBottomSheetBinding
import com.mohsin.emojipicker.emoji.EmojiCategoryTransformer
import com.mohsin.emojipicker.emoji.categories.ActivitiesCategory
import com.mohsin.emojipicker.emoji.categories.AnimalsNatureCategory
import com.mohsin.emojipicker.emoji.categories.Category
import com.mohsin.emojipicker.emoji.categories.FlagsCategory
import com.mohsin.emojipicker.emoji.categories.FoodDrinkCategory
import com.mohsin.emojipicker.emoji.categories.ObjectsCategory
import com.mohsin.emojipicker.emoji.categories.SmileysPeopleCategory
import com.mohsin.emojipicker.emoji.categories.SymbolsCategory
import com.mohsin.emojipicker.emoji.categories.TravelPlacesCategory
import com.mohsin.emojipicker.emoji.categoryUnicodes.EmojiData
import com.mohsin.emojipicker.view.recyclerview.BottomSheetPagesAdapter
import com.mohsin.emojipicker.view.recyclerview.EmojiItemView

class EmojiPickerDialog(
    private val frgManager: FragmentManager,
    private val emojiListener: EmojiClickListener,
    private val theme: Int = R.style.BottomSheetDialogTheme
) : BottomSheetDialogFragment() {

    interface EmojiClickListener {
        fun onEmojiClicked(unicode: String)
    }

    private lateinit var binding: ViewEmojiBottomSheetBinding

    companion object {

        private var emojiCategoriesTransformedList: MutableList<List<EmojiItemView>> =
            emptyList<List<EmojiItemView>>().toMutableList()

        fun initializeEmojiCategories() {
            val emojiCategoriesList = initializeEmojiCategoryList()

            emojiCategoriesTransformedList.clear()
            for (emojiCategory in emojiCategoriesList) {
                val emojisList = EmojiCategoryTransformer().transform(emojiCategory)
                emojiCategoriesTransformedList.add(emojisList)
            }
        }

        private fun initializeEmojiCategoryList(): List<Category> {
            return listOf(
                SmileysPeopleCategory("Smileys and People"),
                ActivitiesCategory("Activity"),
                AnimalsNatureCategory("Animals and Nature"),
                FoodDrinkCategory("Food and Drink"),
                ObjectsCategory("Objects"),
                SymbolsCategory("Symbols"),
                TravelPlacesCategory("Travel and Places"),
                FlagsCategory("Flags")
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ViewEmojiBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun getTheme(): Int {
        return theme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUI()
    }

    private fun setUpUI() {

        val emojiCategoriesTitles = initializeEmojiCategoriesTitles()
        val adapter = BottomSheetPagesAdapter(this)

        val transformData = EmojiCategoryTransformer().transform(EmojiData.data)
        for (emojisList in transformData) {
            val fragment = EmojiFragment.getNewInstance(
                emojisList,
                emojiListener
            )

            adapter.addFragment(fragment)
        }

        binding.emojiViewpager.adapter = adapter

        TabLayoutMediator(
            binding.emojiTitlesTab,
            binding.emojiViewpager
        ) { tab, position ->
            tab.icon = ContextCompat.getDrawable(
                requireContext(), emojiCategoriesTitles[position].second
            )
        }.attach()
    }

    fun show() {
        show(frgManager, EmojiPickerDialog::class.java.simpleName)
    }

    private fun initializeEmojiCategoriesTitles(): List<Pair<String, Int>> {
        return listOf(
            Pair(getString(R.string.smileysAndPeopleTitle), R.drawable.emoji_ios_category_people),
            Pair(
                getString(R.string.activitiesCategoryTitle),
                R.drawable.emoji_ios_category_activity
            ),
            Pair(getString(R.string.animalsAndNatureTitle), R.drawable.emoji_ios_category_nature),
            Pair(getString(R.string.foodAndDrinkTitle), R.drawable.emoji_ios_category_food),
            Pair(getString(R.string.objectsTitle), R.drawable.emoji_ios_category_objects),
            Pair(getString(R.string.symbolsTitle), R.drawable.emoji_ios_category_symbols),
            Pair(getString(R.string.travelAndPlacesTitle), R.drawable.emoji_ios_category_travel),
            Pair(getString(R.string.flagsTitle), R.drawable.emoji_ios_category_flags)
        )
    }
}