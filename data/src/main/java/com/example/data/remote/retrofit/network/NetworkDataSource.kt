package com.example.data.remote.retrofit.network

import com.example.data.remote.retrofit.api.RecipesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val recipesApi: RecipesApi = retrofit.create(RecipesApi::class.java)

    companion object {

        private const val API_KEY = "1"
        private const val BASE_URL = "www.themealdb.com/api/json/v1/$API_KEY/"

    }
}
