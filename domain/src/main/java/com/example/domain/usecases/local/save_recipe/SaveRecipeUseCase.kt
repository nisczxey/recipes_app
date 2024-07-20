package com.example.domain.usecases.local.save_recipe

import com.example.domain.model.RecipeEntity
import com.example.domain.repo.LocalRecipesRepository
import com.example.domain.usecases.network.get_recipe.GetRecipeByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveRecipeUseCase(
    private val repo: LocalRecipesRepository,
    private val getRecipeFromNetworkUseCase: GetRecipeByIdUseCase
) {
    suspend operator fun invoke(itemId: String): RecipeEntity {
        return try {
            // Получение рецепта из сети
            val item = getRecipeFromNetworkUseCase.invoke(itemId)

            // Сохранение рецепта в локальный репозиторий
            withContext(Dispatchers.IO) {
                repo.saveRecipe(item)
            }
          item
        } catch (e: Exception) {
            RecipeEntity("","","",true,"","")
        }
    }
}