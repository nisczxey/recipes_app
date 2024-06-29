package com.example.data.local.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.db.models.RecipeDbModel

@Database(
    entities = [RecipeDbModel::class],
    version = 1
)
abstract class RecipeDatabase : RoomDatabase() {

    abstract val dao: RecipesDao

    companion object {
        fun createDb(context: Context): RecipeDatabase {
            return Room.databaseBuilder(
                context = context,
                RecipeDatabase::class.java,
                "recipes.db"
            ).build()
        }
    }
}