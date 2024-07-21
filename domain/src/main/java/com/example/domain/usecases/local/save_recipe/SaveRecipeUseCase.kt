package com.example.domain.usecases.local.save_recipe

import com.example.domain.repo.LocalRecipesRepository
import com.example.domain.usecases.network.get_recipe.GetRecipeByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveRecipeUseCase(
    private val repo: LocalRecipesRepository,
    private val getRecipeFromNetworkUseCase: GetRecipeByIdUseCase
) {
    suspend operator fun invoke(itemId: String) {
        try {
            val item = getRecipeFromNetworkUseCase.invoke(itemId)
            withContext(Dispatchers.IO) {
                repo.saveRecipe(item)
            }

        } catch (e: Exception) {
            throw e
        }
    }
}