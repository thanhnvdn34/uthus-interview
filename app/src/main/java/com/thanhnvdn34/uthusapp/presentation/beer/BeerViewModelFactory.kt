package com.thanhnvdn34.uthusapp.presentation.beer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thanhnvdn34.uthusapp.domain.usecase.*

class BeerViewModelFactory(
    private val getBeersUseCase: GetBeersUseCase,
    private val getBeersFromDBUseCase: GetBeersFromDBUseCase,
    private val saveBeerToDBUseCase: SaveBeerToDBUseCase,
    private val saveBeersToDBUseCase: SaveBeersToDBUseCase,
    private val updateBeerUseCase: UpdateBeerUseCase,
    private val deleteBeerUseCase: DeleteBeerUseCase,
    private val clearAllUseCase: ClearAllUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BeerViewModel(
            getBeersUseCase,
            getBeersFromDBUseCase,
            saveBeerToDBUseCase,
            saveBeersToDBUseCase,
            updateBeerUseCase,
            deleteBeerUseCase,
            clearAllUseCase
        ) as T
    }
}