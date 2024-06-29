package com.example.recipes_app.di

import com.example.data.local.db.room.RecipeDatabase
import com.example.data.local.prefs.Prefs
import com.example.data.remote.retrofit.network.NetworkDataSource
import com.example.data.repo.LocalRepositoryImpl
import com.example.data.repo.NetworkRepositoryImpl
import com.example.domain.repo.LocalRecipesRepository
import com.example.domain.repo.NetworkRepository
import org.koin.dsl.module

val dataModule = module {

    single<NetworkDataSource> {
        NetworkDataSource()
    }

    single<RecipeDatabase> {
        RecipeDatabase.createDb(
            context = get()
        )
    }

    single<Prefs> {
        Prefs(context = get())
    }

    single<NetworkRepository> {
        NetworkRepositoryImpl(
            network = get()
        )
    }

    single<LocalRecipesRepository> {
        LocalRepositoryImpl(
            prefs = get(),
            db = get()
        )
    }


}