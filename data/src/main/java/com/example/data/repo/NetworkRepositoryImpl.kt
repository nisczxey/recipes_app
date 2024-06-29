package com.example.data.repo

import com.example.data.mapper.toCategoryEntity
import com.example.data.mapper.toRecipeEntity
import com.example.data.remote.retrofit.network.NetworkDataSource
import com.example.domain.model.CategoryEntity
import com.example.domain.model.RecipeEntity
import com.example.domain.repo.NetworkRepository

class NetworkRepositoryImpl(
    val network: NetworkDataSource
) : NetworkRepository {

    override suspend fun getRecipeById(id: String): RecipeEntity {
        return network.recipesApi.getMealDetailById(id).recipes.first().toRecipeEntity()
    }

    override suspend fun getRandomRecipe(): RecipeEntity {
        return network.recipesApi.getRandomMeal().recipes.first().toRecipeEntity()
    }

    override suspend fun searchRecipesByName(name: String): List<RecipeEntity> {
        return  network.recipesApi.searchMealByName(name).recipes.map {
            it.toRecipeEntity()
        }
    }

    override suspend fun searchRecipesByMainIngredient(ingredient: String): List<RecipeEntity> {
        return network.recipesApi.filterMealByMainIngredient(ingredient).recipes.map {
            it.toRecipeEntity()
        }
    }

    override suspend fun getAllCategories(): List<CategoryEntity> {
        return network.recipesApi.getAllMealsCategories().categories.map {
            it.toCategoryEntity()
        }
    }

    override suspend fun getRecipesByCategory(category: String): List<RecipeEntity> {
        return network.recipesApi.filterMealsByCategory(category).recipes.map {
            it.toRecipeEntity()
        }
    }

}