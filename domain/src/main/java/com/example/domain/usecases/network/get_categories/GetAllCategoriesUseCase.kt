package com.example.domain.usecases.network.get_categories

import com.example.domain.repo.NetworkRepository
import com.example.domain.util.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetAllCategoriesUseCase(
    private val repository: NetworkRepository
) {

    operator fun invoke() = flow {
        emit(Resource.Loading())
        try {
            val categories = repository.getAllCategories()
            emit(Resource.Success(categories))
        } catch (e: IOException) {
            emit(Resource.Error(msg = e.toString()))
            throw e
        }
    }

}