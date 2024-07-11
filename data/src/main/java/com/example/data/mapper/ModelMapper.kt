package com.example.data.mapper

import com.example.data.local.db.models.RecipeDbModel
import com.example.data.remote.dto.Category
import com.example.data.remote.dto.Recipe
import com.example.domain.model.CategoryEntity
import com.example.domain.model.RecipeEntity

fun RecipeEntity.toRecipeDbModel() = RecipeDbModel(
    id = id,
    name = name,
    instructions = instructions.toString(),
    isFavorite = isFavorite,
    area = area.toString(),
    category = category.toString()
)

fun RecipeDbModel.toRecipeEntity() = RecipeEntity(
    id = id,
    name = name,
    instructions = instructions,
    isFavorite = isFavorite,
    area = area,
    category = category
)

fun Recipe.toRecipeEntity() = RecipeEntity(
    id = id,
    name = name,
    instructions = instructions,
    isFavorite = false,
    area = area,
    category = category,
    img = mealThumbUrl
)

fun Category.toCategoryEntity() = CategoryEntity(
    id = id,
    name = name,
    imgUrl = categoryThumbUrl,
    description = categoryDesc
)