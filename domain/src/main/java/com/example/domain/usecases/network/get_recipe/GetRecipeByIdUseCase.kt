package com.example.domain.usecases.network.get_recipe

import com.example.domain.model.RecipeEntity
import com.example.domain.repo.NetworkRepository

class GetRecipeByIdUseCase(
    private val repository: NetworkRepository,
) {

    suspend operator fun invoke(id: String): RecipeEntity {
        return repository.getRecipeById(id)
    }

}