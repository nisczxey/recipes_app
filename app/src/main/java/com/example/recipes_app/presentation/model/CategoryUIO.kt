package com.example.recipes_app.presentation.model

import com.example.domain.model.CategoryEntity

data class CategoryUIO (
    val id: String,
    val name: String,
    val imgUrl: String,
    val desc: String? = null
)

fun CategoryEntity.toUIO() = CategoryUIO(
    id = id,
    name =  name,
    imgUrl = imgUrl,
    desc = description
)