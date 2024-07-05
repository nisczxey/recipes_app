package com.example.domain.usecases.local.get_recipes

import com.example.domain.model.RecipeEntity
import com.example.domain.repo.LocalRecipesRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.Flow

class GetAllSavedRecipesUseCase(
    private val repository: LocalRecipesRepository
) {
    operator fun invoke(): List<RecipeEntity> {
        return repository.getAllRecipes().data ?: emptyList()
    }

}