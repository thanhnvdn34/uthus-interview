package com.thanhnvdn34.uthusapp.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thanhnvdn34.uthusapp.domain.usecase.*

class FavoriteViewModelFactory(
    private val getBeersFromDBUseCase: GetBeersFromDBUseCase,
    private val updateBeerUseCase: UpdateBeerUseCase,
    private val deleteBeerUseCase: DeleteBeerUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoriteViewModel(
            getBeersFromDBUseCase,
            updateBeerUseCase,
            deleteBeerUseCase
        ) as T
    }
}