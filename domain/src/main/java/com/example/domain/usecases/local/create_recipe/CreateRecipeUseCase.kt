package com.example.domain.usecases.local.create_recipe

import com.example.domain.model.RecipeEntity
import com.example.domain.repo.LocalRecipesRepository

class CreateRecipeUseCase(
    private val repository: LocalRecipesRepository
) {

     suspend operator fun invoke(recipe: RecipeEntity){
         repository.saveRecipe(recipe)
     }

}