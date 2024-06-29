package com.example.domain.usecases.network.get_recipe

import com.example.domain.repo.NetworkRepository

class GetRecipeByIdUseCase(
    val repository: NetworkRepository,
) {

    operator fun invoke(id: String) {

    }

}