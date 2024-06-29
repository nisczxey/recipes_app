package com.example.domain.usecases.local.boarding

import com.example.domain.repo.LocalRecipesRepository

class OnBoardingShowedUseCase(
    private val  repository: LocalRecipesRepository
) {
    operator fun invoke(){
        repository.boardingShowed()
    }
}