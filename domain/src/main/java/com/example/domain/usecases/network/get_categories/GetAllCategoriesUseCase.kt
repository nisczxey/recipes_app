package com.example.domain.usecases.network.get_categories

import com.example.domain.model.CategoryEntity
import com.example.domain.repo.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllCategoriesUseCase(
    private  val repository: NetworkRepository
) {

    suspend operator fun invoke(): List<CategoryEntity> {
        return repository.getAllCategories()
    }

}