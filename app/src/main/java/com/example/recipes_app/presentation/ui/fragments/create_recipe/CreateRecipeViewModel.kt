package com.example.recipes_app.presentation.ui.fragments.create_recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.local.create_recipe.CreateRecipeUseCase
import kotlinx.coroutines.launch

class CreateRecipeViewModel(
    private val createRecipeUseCase: CreateRecipeUseCase
) : ViewModel() {


    fun create(name: String, instructions: String) {
        viewModelScope.launch {

            TODO()
        }
    }
}