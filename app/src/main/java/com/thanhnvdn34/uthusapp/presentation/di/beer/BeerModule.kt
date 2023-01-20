package com.thanhnvdn34.uthusapp.presentation.di.beer

import com.thanhnvdn34.uthusapp.domain.usecase.*
import com.thanhnvdn34.uthusapp.presentation.beer.BeerViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class BeerModule {

    @BeerScope
    @Provides
    fun provideDataViewModelFactory(
        getBeersUseCase: GetBeersUseCase,
        getBeersFromDBUseCase: GetBeersFromDBUseCase,
        saveBeerToDBUseCase: SaveBeerToDBUseCase,
        saveBeersToDBUseCase: SaveBeersToDBUseCase,
        updateBeerUseCase: UpdateBeerUseCase,
        deleteBeerUseCase: DeleteBeerUseCase,
        clearAllUseCase: ClearAllUseCase
    ): BeerViewModelFactory {
        return BeerViewModelFactory(
            getBeersUseCase,
            getBeersFromDBUseCase,
            saveBeerToDBUseCase,
            saveBeersToDBUseCase,
            updateBeerUseCase,
            deleteBeerUseCase,
            clearAllUseCase
        )
    }
}