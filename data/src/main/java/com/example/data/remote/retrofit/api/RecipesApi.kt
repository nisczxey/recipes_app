package com.example.data.remote.retrofit.api

import com.example.data.remote.dto.RecipesCategories
import com.example.data.remote.dto.RecipesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesApi {

    @GET("categories.php")
    suspend fun getAllMealsCategories(): RecipesCategories

    @GET("lookup.php")
    suspend fun getMealDetailById(@Query("i") id: String): RecipesModel

    @GET("search.php")
    suspend fun searchMealByName(@Query("s") name: String): RecipesModel

    @GET("filter.php")
    suspend fun filterMealsByCategory(@Query("c") category: String): RecipesModel

    @GET("filter.php")
    suspend fun  filterMealByMainIngredient(@Query("i") ingredient: String): RecipesModel

    @GET("random.php")
    suspend fun getRandomMeal(): RecipesModel

}