package com.example.recipes_app.presentation.ui.fragments.search.adapters.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.recipes_app.presentation.model.CategoryUIO

class CategoryItemDiffCallback : DiffUtil.ItemCallback<CategoryUIO>() {

    override fun areItemsTheSame(oldItem: CategoryUIO, newItem: CategoryUIO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryUIO, newItem: CategoryUIO): Boolean {
        return  oldItem == newItem
    }

}