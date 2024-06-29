package com.example.recipes_app.presentation.ui.fragments.onBoarding

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.local.boarding.IsBoardingShownUseCase
import com.example.domain.usecases.local.boarding.OnBoardingShowedUseCase

class OnBoardingViewModel(
    val boardingShowedUseCase: OnBoardingShowedUseCase
): ViewModel() {

    fun onBoardingShown(){
        boardingShowedUseCase()
    }

}