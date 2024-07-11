package com.example.domain.usecases.network.get_recipes

import com.example.domain.model.RecipeEntity
import com.example.domain.repo.NetworkRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetRecipesByCategoryUseCase(
    private val repository: NetworkRepository
) {

    operator fun invoke(category: String) =
        flow<Resource<List<RecipeEntity>>> {
            try {
                emit(Resource.Loading())
                val recipes = repository.getRecipesByCategory(category)
                emit(Resource.Success(recipes))
            } catch (e: IOException) {
                throw e
            }
        }

}