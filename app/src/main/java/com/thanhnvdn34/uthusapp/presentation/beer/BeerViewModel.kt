package com.thanhnvdn34.uthusapp.presentation.beer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.domain.usecase.*

class BeerViewModel(
    private val getBeersUseCase: GetBeersUseCase,
    private val getBeersFromDBUseCase: GetBeersFromDBUseCase,
    private val saveBeerToDBUseCase: SaveBeerToDBUseCase,
    private val saveBeersToDBUseCase: SaveBeersToDBUseCase,
    private val updateBeerUseCase: UpdateBeerUseCase,
    private val deleteBeerUseCase: DeleteBeerUseCase,
    private val clearAllUseCase: ClearAllUseCase
): ViewModel() {

    fun getBeers(input: Int) = liveData {
        val response = getBeersUseCase.execute(input)
        emit(response)
    }

    fun getBeersFromDB() = liveData {
        val response = getBeersFromDBUseCase.execute()
        emit(response)
    }

    fun saveBeerToDB(input: Beer) = liveData {
        val response = saveBeerToDBUseCase.execute(input)
        emit(response)
    }

}