package com.thanhnvdn34.uthusapp.presentation.di.favorite

import com.thanhnvdn34.uthusapp.domain.usecase.*
import com.thanhnvdn34.uthusapp.presentation.beer.BeerViewModelFactory
import com.thanhnvdn34.uthusapp.presentation.favorite.FavoriteViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class FavoriteModule {

    @FavoriteScope
    @Provides
    fun provideFavoriteViewModelFactory(
        getBeersFromDBUseCase: GetBeersFromDBUseCase,
        updateBeerUseCase: UpdateBeerUseCase,
        deleteBeerUseCase: DeleteBeerUseCase,
    ): FavoriteViewModelFactory {
        return FavoriteViewModelFactory(
            getBeersFromDBUseCase,
            updateBeerUseCase,
            deleteBeerUseCase
        )
    }
}