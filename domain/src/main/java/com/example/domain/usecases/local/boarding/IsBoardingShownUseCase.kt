package com.example.domain.usecases.local.boarding

import com.example.domain.repo.LocalRecipesRepository

class IsBoardingShownUseCase(
    private val repository: LocalRecipesRepository
) {
    operator fun invoke(): Boolean {
        return repository.isBoardingShown()
    }
}