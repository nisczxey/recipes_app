package com.example.recipes_app.presentation.ui.fragments.cook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.network.get_recipe.GetRandomRecipeUseCase
import com.example.recipes_app.presentation.model.RecipeUIO
import com.example.recipes_app.presentation.model.toUIO
import kotlinx.coroutines.launch

class CookViewModel(
    private val getRandomRecipeUseCase: GetRandomRecipeUseCase
) : ViewModel() {

    private var _stateLD = MutableLiveData<RecipeUIO>()
    val stateLD: LiveData<RecipeUIO>
        get() = _stateLD

    fun getRandomRecipe() {
         viewModelScope.launch {
             val data = getRandomRecipeUseCase()
             _stateLD.postValue(data.toUIO())
        }
    }

}