package com.example.data.local.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")
data class RecipeDbModel(
    @PrimaryKey
    val id : String,
    val name: String,
    val isFavorite: Boolean = false,
    val instructions: String,
    val category: String,
    val area: String
)

