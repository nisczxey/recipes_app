package com.example.data.local.db.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.db.models.RecipeDbModel
import kotlinx.coroutines.flow.Flow


@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeToSaved(recipe: RecipeDbModel)

    @Delete
    suspend fun deleteRecipeFromSaved(recipe: RecipeDbModel)

    @Query("select * from recipes_table")
    suspend fun getAllRecipes(): List<RecipeDbModel>

    @Query("select * from recipes_table ORDER BY name")
    suspend fun getRecipesOrderedByName(): List<RecipeDbModel>

    @Query("select * from recipes_table where isFavorite = 1")
    suspend fun getFavoriteRecipes(): List<RecipeDbModel>

}