package com.example.recipes_app.presentation.ui.fragments.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.local.get_recipes.GetAllSavedRecipesUseCase
import com.example.recipes_app.presentation.model.RecipeUIO
import com.example.recipes_app.presentation.model.states.RecipeItemsState
import com.example.recipes_app.presentation.model.toUIO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LibraryViewModel(
    private val getSavedRecipesUseCase: GetAllSavedRecipesUseCase
) : ViewModel() {

    private var getRecipesJob: Job? = null

    private var _recipesLiveData = MutableLiveData(RecipeItemsState())
    val recipesLiveData: LiveData<RecipeItemsState> = _recipesLiveData

    fun getAllRecipes() {
        getRecipesJob?.cancel()
        getRecipesJob = viewModelScope.launch(Dispatchers.IO) {
            val list: List<RecipeUIO> = getSavedRecipesUseCase().map { it.toUIO() }
            withContext(Dispatchers.Main) {
                _recipesLiveData.value = list.let {
                    recipesLiveData.value?.copy(
                        list = it,
                        isLoading = false
                    )
                }
            }
        }
    }

}