package com.example.recipes_app.presentation.model.states

import com.example.recipes_app.presentation.model.RecipeUIO

data class RecipeItemsState (
    var list: List<RecipeUIO> = emptyList(),
    val isLoading: Boolean = false
)