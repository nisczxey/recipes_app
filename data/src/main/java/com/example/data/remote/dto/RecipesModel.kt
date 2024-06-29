package com.example.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RecipesModel(
    @SerializedName("meals")
    val recipes: List<Recipe>
)

data class Recipe(
    @SerializedName("idMeal")
    val id: String,
    @SerializedName("strMeal")
    val name: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strArea")
    val area: String,
    @SerializedName("strInstructions")
    val instructions: String,
    @SerializedName("strMealThumb")
    val mealThumbUrl: String,
    @SerializedName("strYoutube")
    val youtubeUrl: String
)

