package com.thanhnvdn34.uthusapp.domain.usecase

import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class SaveBeersToDBUseCase(private val repository: DataRepository) {

    suspend fun execute(input: List<Beer>) = repository.saveBeersToDB(input)

}