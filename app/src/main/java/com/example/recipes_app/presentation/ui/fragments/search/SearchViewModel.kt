package com.example.recipes_app.presentation.ui.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.network.get_categories.GetAllCategoriesUseCase
import com.example.recipes_app.presentation.model.CategoryUIO
import com.example.recipes_app.presentation.model.toUIO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) : ViewModel() {

    private var _categoriesLD: MutableLiveData<List<CategoryUIO>> = MutableLiveData(emptyList())
    val categoriesLD: LiveData<List<CategoryUIO>> = _categoriesLD

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

    fun getRecipesByCategory() {

    }

}