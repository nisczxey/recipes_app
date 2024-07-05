package com.example.domain.repo

import com.example.domain.model.RecipeEntity
import com.example.domain.util.Resource

interface LocalRecipesRepository {

    fun boardingShowed()

    fun isBoardingShown(): Boolean

    suspend fun saveRecipe(recipe: RecipeEntity)

    suspend fun deleteRecipe(recipe: RecipeEntity)

    fun getAllRecipes(): Resource<List<RecipeEntity>>

    suspend fun getRecipesOrderedByName(): List<RecipeEntity>

    suspend fun getFavoriteRecipes(): List<RecipeEntity>

}