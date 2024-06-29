package com.example.data.repo

import com.example.data.local.db.room.RecipeDatabase
import com.example.data.local.prefs.Prefs
import com.example.data.mapper.toRecipeDbModel
import com.example.data.mapper.toRecipeEntity
import com.example.domain.model.RecipeEntity
import com.example.domain.repo.LocalRecipesRepository

class LocalRepositoryImpl(
    val prefs: Prefs,
    val db: RecipeDatabase
) : LocalRecipesRepository {

    override fun boardingShowed() {
        prefs.onBoardingShowed()
    }

    override fun isBoardingShown(): Boolean {
        return prefs.isOnBoardingShowed()
    }

    override suspend fun saveRecipe(recipe: RecipeEntity) {
        db.dao.insertRecipeToSaved(recipe = recipe.toRecipeDbModel())
    }

    override suspend fun deleteRecipe(recipe: RecipeEntity) {
        db.dao.deleteRecipeFromSaved(recipe = recipe.toRecipeDbModel())
    }

    override suspend fun getAllRecipes() : List<RecipeEntity> {
       return db.dao.getAllRecipes().map {
           it.toRecipeEntity()
       }
    }

    override suspend fun getRecipesOrderedByName(): List<RecipeEntity> {
        return db.dao.getRecipesOrderedByName().map {
            it.toRecipeEntity()
        }
    }

    override suspend fun getFavoriteRecipes(): List<RecipeEntity> {
        return db.dao.getFavoriteRecipes().map {
            it.toRecipeEntity()
        }
    }

}