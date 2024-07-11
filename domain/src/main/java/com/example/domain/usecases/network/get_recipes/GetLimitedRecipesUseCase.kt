package com.example.domain.usecases.network.get_recipes

import com.example.domain.repo.NetworkRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetLimitedRecipesUseCase(
    private val repository: NetworkRepository
) {

    operator fun invoke(category: String) =
        flow {
            emit(Resource.Loading())
            try {
                val recipes = repository.getRecipesByCategory(category)
                val limitedRecipes = recipes.take(LIMIT_COUNT_RECIPES)
                emit(Resource.Success(limitedRecipes))
            } catch (e: IOException) {
                throw e
            }
        }

    companion object{
        const val LIMIT_COUNT_RECIPES = 7
    }
}