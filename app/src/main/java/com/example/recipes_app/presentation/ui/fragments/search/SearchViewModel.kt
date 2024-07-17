package com.example.recipes_app.presentation.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.network.get_categories.GetAllCategoriesUseCase
import com.example.domain.usecases.network.get_recipes.GetLimitedRecipesUseCase
import com.example.domain.util.Resource
import com.example.recipes_app.presentation.model.states.CategoryItemsState
import com.example.recipes_app.presentation.model.states.RecipeItemsState
import com.example.recipes_app.presentation.model.toUIO
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SearchViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getLimitedRecipesByCategoryUseCase: GetLimitedRecipesUseCase
) : ViewModel() {

    private val _categoryStateLD = MutableLiveData<CategoryItemsState>()
    val categoryStateLD: LiveData<CategoryItemsState> = _categoryStateLD

    private val _recipesStateLD = MutableLiveData<RecipeItemsState>()
    val recipesStateLD: LiveData<RecipeItemsState> = _recipesStateLD

    fun getAllCategories() {
        getAllCategoriesUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _categoryStateLD.value = CategoryItemsState(
                        error = result.msg.toString()
                    )
                }

                is Resource.Loading -> {
                    _categoryStateLD.value = CategoryItemsState(
                        isLoading = true
                    )
                }

                is Resource.Success -> {
                    _categoryStateLD.value = CategoryItemsState(
                        list = result.data?.map { it.toUIO() } ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getLimitedRecipesByCategory(category: String) {
        getLimitedRecipesByCategoryUseCase(category).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _recipesStateLD.value = RecipeItemsState(
                        list = result.data?.map { it.toUIO() } ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _recipesStateLD.value = RecipeItemsState(
                        error = result.msg.toString()
                    )
                }

                is Resource.Loading -> {
                    _recipesStateLD.value = RecipeItemsState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}