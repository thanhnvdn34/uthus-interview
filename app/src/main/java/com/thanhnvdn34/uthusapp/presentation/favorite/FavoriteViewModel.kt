package com.thanhnvdn34.uthusapp.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.domain.usecase.*

class FavoriteViewModel(
    private val getBeersFromDBUseCase: GetBeersFromDBUseCase,
    private val updateBeerUseCase: UpdateBeerUseCase,
    private val deleteBeerUseCase: DeleteBeerUseCase
): ViewModel() {

    fun getBeersFromDB() = liveData {
        val response = getBeersFromDBUseCase.execute()
        emit(response)
    }

    fun updateBeer(id: Int,description: String) = liveData {
        val response = updateBeerUseCase.execute(id, description)
        emit(response)
    }
    fun deleteBeer(input: Int) = liveData {
        val response = deleteBeerUseCase.execute(input)
        emit(response)
    }

}