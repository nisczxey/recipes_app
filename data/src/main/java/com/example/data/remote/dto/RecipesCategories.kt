package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RecipesCategories(
    @SerializedName("categories")
    val categories: List<Category>
)

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val categoryThumbUrl: String,
    @SerializedName("strCategoryDescription")
    val categoryDesc: String
)
