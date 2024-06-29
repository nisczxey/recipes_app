package com.example.domain.repo

import com.example.domain.model.RecipeEntity

interface LocalRecipesRepository {

    fun boardingShowed()

    fun isBoardingShown(): Boolean

    suspend fun saveRecipe(recipe: RecipeEntity)

    suspend fun deleteRecipe(recipe: RecipeEntity)

    suspend fun getAllRecipes(): List<RecipeEntity>

    suspend fun getRecipesOrderedByName(): List<RecipeEntity>

    suspend fun getFavoriteRecipes(): List<RecipeEntity>

}