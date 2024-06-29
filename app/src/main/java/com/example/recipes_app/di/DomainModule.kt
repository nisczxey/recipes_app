package com.example.recipes_app.di

import com.example.domain.usecases.local.boarding.IsBoardingShownUseCase
import com.example.domain.usecases.local.boarding.OnBoardingShowedUseCase
import com.example.domain.usecases.network.get_categories.GetAllCategoriesUseCase
import com.example.domain.usecases.network.get_recipe.GetRecipeByIdUseCase
import com.example.domain.usecases.network.get_recipes.GetAllRecipesUseCase
import com.example.domain.usecases.network.get_recipes.GetRecipesByCategoryUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<IsBoardingShownUseCase> {
        IsBoardingShownUseCase(get())
    }

    factory<OnBoardingShowedUseCase> {
        OnBoardingShowedUseCase(get())
    }

    factory<GetAllCategoriesUseCase> {
        GetAllCategoriesUseCase(get())
    }

    factory<GetAllRecipesUseCase> {
        GetAllRecipesUseCase(get())
    }

    factory<GetRecipesByCategoryUseCase> {
        GetRecipesByCategoryUseCase(get())
    }

    factory<GetRecipeByIdUseCase> {
        GetRecipeByIdUseCase(get())
    }
}