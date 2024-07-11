package com.example.recipes_app.presentation.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.network.get_categories.GetAllCategoriesUseCase
import com.example.domain.usecases.network.get_recipes.GetLimitedRecipesUseCase
import com.example.domain.util.Resource
import com.example.recipes_app.presentation.model.CategoryUIO
import com.example.recipes_app.presentation.model.states.RecipeItemsState
import com.example.recipes_app.presentation.model.toUIO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getLimitedRecipesByCategoryUseCase: GetLimitedRecipesUseCase
) : ViewModel() {

    private val _categoriesLD: MutableLiveData<List<CategoryUIO>> = MutableLiveData(emptyList())
    val categoriesLD: LiveData<List<CategoryUIO>> = _categoriesLD

    private val _recipesStateLD = MutableLiveData<RecipeItemsState>()
    val recipesStateLD: LiveData<RecipeItemsState> = _recipesStateLD

    private lateinit var categoryList: List<CategoryUIO>


    fun getAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            categoryList = getAllCategoriesUseCase().map {
                it.toUIO()
            }
            withContext(Dispatchers.Main) {
                _categoriesLD.value = categoryList
            }
        }
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