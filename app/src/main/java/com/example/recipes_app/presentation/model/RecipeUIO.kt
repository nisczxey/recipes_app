package com.example.recipes_app.presentation.model

import com.example.domain.model.RecipeEntity

data class RecipeUIO(
    val id: String,
    val name: String,
    val instructions: String,
    val area: String? = null,
    val imgUrl: String? = null,
    val isFavorite: Boolean? = null
)

fun RecipeEntity.toUIO() = RecipeUIO(
    id = id,
    name = name,
    instructions = instructions.toString(),
    area = area,
    isFavorite = isFavorite,
    imgUrl = img
)