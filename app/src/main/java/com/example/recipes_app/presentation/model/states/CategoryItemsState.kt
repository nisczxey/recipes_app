package com.example.recipes_app.presentation.model.states

import com.example.recipes_app.presentation.model.CategoryUIO

data class CategoryItemsState(
    var list:List<CategoryUIO> = emptyList(),
    val isLoading:Boolean = false,
    val error: String = ""
)
