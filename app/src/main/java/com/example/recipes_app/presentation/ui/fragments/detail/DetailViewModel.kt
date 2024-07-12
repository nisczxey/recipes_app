package com.example.recipes_app.presentation.ui.fragments.detail

import android.util.Log
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

    val ld: MutableLiveData<RecipeUIO> = MutableLiveData()


    fun getRecipe(id: String) {
        viewModelScope.launch {
           ld.value = getRecipeByIdUseCase(id).toUIO()
        }
    }
}