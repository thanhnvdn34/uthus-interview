package com.thanhnvdn34.uthusapp.domain.usecase

import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class DeleteBeerUseCase(private val repository: DataRepository) {

    suspend fun execute(input: Int) = repository.deleteBeer(input)

}