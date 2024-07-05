package com.example.data.repo

import android.util.Log
import com.example.data.local.db.room.RecipeDatabase
import com.example.data.local.prefs.Prefs
import com.example.data.mapper.toRecipeDbModel
import com.example.data.mapper.toRecipeEntity
import com.example.domain.model.RecipeEntity
import com.example.domain.repo.LocalRecipesRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

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
        db.recipeDao().insertRecipeToSaved(recipe = recipe.toRecipeDbModel())
    }

    override suspend fun deleteRecipe(recipe: RecipeEntity) {
        db.recipeDao().deleteRecipeFromSaved(recipe = recipe.toRecipeDbModel())
    }

    override fun getAllRecipes(): Resource<List<RecipeEntity>> {

        val recipes = db.recipeDao().getAllRecipes().map { it.toRecipeEntity() }

        return try {
            (Resource.Success(recipes))
        } catch (e : IOException){
            (Resource.Error(e.toString(), recipes))
            throw e
        }

    }


    override suspend fun getRecipesOrderedByName(): List<RecipeEntity> {
        return db.recipeDao().getRecipesOrderedByName().map {
            it.toRecipeEntity()
        }
    }

    override suspend fun getFavoriteRecipes(): List<RecipeEntity> {
        return db.recipeDao().getFavoriteRecipes().map {
            it.toRecipeEntity()
        }
    }

}