package com.thanhnvdn34.uthusapp.domain.usecase

import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class UpdateBeerUseCase(private val repository: DataRepository) {

    suspend fun execute(id: Int,description: String) = repository.updateBeer(id, description)
}