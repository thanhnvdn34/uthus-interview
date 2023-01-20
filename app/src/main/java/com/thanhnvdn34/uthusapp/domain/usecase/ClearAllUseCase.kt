package com.thanhnvdn34.uthusapp.domain.usecase

import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class ClearAllUseCase(private val repository: DataRepository) {

    suspend fun execute() = repository.clearALl()

}