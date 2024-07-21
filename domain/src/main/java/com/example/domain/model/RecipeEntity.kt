package com.example.domain.model

data class RecipeEntity(
    val id: String,
    val name: String,
    val instructions: String?,
    val isFavorite: Boolean,
    val area: String?,
    val category: String?,
    val img: String,
    val youtubeUrl: String? = null
)
