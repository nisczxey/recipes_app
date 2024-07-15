package com.example.recipes_app.presentation.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.network.get_recipe.GetRecipeByIdUseCase
import com.example.recipes_app.presentation.model.RecipeUIO
import com.example.recipes_app.presentation.model.toUIO
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getRecipeByIdUseCase: GetRecipeByIdUseCase
) : ViewModel() {

    val _ld: MutableLiveData<RecipeUIO> = MutableLiveData()
    val ld: LiveData<RecipeUIO> = _ld


    fun getRecipe(id: String) {
        viewModelScope.launch {
           _ld.value = getRecipeByIdUseCase(id).toUIO()
        }
    }
}