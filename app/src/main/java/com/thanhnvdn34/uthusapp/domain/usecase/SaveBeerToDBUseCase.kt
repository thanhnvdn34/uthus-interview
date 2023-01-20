package com.thanhnvdn34.uthusapp.domain.usecase

import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class SaveBeerToDBUseCase(private val repository: DataRepository) {

    suspend fun execute(input: Beer) = repository.saveBeerToDB(input)

}