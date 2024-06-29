package com.example.recipes_app.presentation.model

data class RecipeUIO(
    val id: String,
    val name: String,
    val instructions: String,
    val area: String? = null,
    val imgUrl: String,
    val youtubeUrl: String,
    val isFavorite: Boolean? = null
)
