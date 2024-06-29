package com.example.recipes_app.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.local.boarding.IsBoardingShownUseCase

class MainActivityViewModel(
    val isBoardingShownUseCase: IsBoardingShownUseCase
) : ViewModel() {

    fun isBoardingShowed(): Boolean {
        return isBoardingShownUseCase()
    }
}