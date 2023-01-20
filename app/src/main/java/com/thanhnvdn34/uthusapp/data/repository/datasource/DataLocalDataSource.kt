package com.thanhnvdn34.uthusapp.data.repository.datasource

import com.thanhnvdn34.uthusapp.data.model.Beer

interface DataLocalDataSource {

    suspend fun getBeersFromDB(): List<Beer>

    suspend fun saveBeersToDB(beers: List<Beer>)

    suspend fun saveBeerToDB(beers: Beer)

    suspend fun updateBeer(id: Int, description: String)

    suspend fun deleteBeer(id: Int)

    suspend fun clearALl()

}