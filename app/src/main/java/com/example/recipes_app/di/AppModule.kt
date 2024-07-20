package com.example.recipes_app.di

import com.example.recipes_app.presentation.ui.MainActivityViewModel
import com.example.recipes_app.presentation.ui.fragments.cook.CookViewModel
import com.example.recipes_app.presentation.ui.fragments.detail.DetailViewModel
import com.example.recipes_app.presentation.ui.fragments.library.LibraryViewModel
import com.example.recipes_app.presentation.ui.fragments.onBoarding.OnBoardingViewModel
import com.example.recipes_app.presentation.ui.fragments.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(
            isBoardingShownUseCase = get()
        )
    }
    viewModel<OnBoardingViewModel> {
        OnBoardingViewModel(
            boardingShowedUseCase = get()
        )
    }

    viewModel<SearchViewModel> {
        SearchViewModel(
            getAllCategoriesUseCase = get(),
            getLimitedRecipesByCategoryUseCase = get(),
            saveUseCase = get()
        )
    }
    viewModel<LibraryViewModel> {
        LibraryViewModel(
            getSavedRecipesUseCase = get()
        )
    }
    viewModel<DetailViewModel>{
        DetailViewModel(getRecipeByIdUseCase = get(),
            saveRecipeUseCase = get())
    }

    viewModel<CookViewModel>{
        CookViewModel(getRandomRecipeUseCase = get())
    }
}