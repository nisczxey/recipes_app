package com.example.domain.repo

import com.example.domain.model.CategoryEntity
import com.example.domain.model.RecipeEntity

interface NetworkRepository {

    suspend fun getRecipeById(id: String): RecipeEntity

    suspend fun getAllCategories(): List<CategoryEntity>

    suspend fun getRecipesByCategory(category: String): List<RecipeEntity>

    suspend fun getRandomRecipe(): RecipeEntity

    suspend fun searchRecipesByName(name: String): List<RecipeEntity>

    suspend fun searchRecipesByMainIngredient(ingredient: String): List<RecipeEntity>
}