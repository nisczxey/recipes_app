package com.example.recipes_app.presentation.ui.fragments.search.adapters.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.recipes_app.presentation.model.RecipeUIO

class RecipesItemDiffCallback : DiffUtil.ItemCallback<RecipeUIO>() {

    override fun areItemsTheSame(oldItem: RecipeUIO, newItem: RecipeUIO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecipeUIO, newItem: RecipeUIO): Boolean {
        return oldItem == newItem
    }

}