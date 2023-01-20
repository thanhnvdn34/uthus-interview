package com.thanhnvdn34.uthusapp.domain.usecase

import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.data.model.Data
import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class GetBeersUseCase(private val repository: DataRepository){

    suspend fun execute(input: Int): List<Beer> = repository.getBeers(input)

}