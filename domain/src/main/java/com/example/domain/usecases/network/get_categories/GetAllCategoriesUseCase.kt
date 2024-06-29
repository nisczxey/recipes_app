package com.example.domain.usecases.network.get_categories

import com.example.domain.repo.NetworkRepository

class GetAllCategoriesUseCase(
    private  val repository: NetworkRepository
) {

    suspend operator fun invoke() {
        TODO()
    }

}