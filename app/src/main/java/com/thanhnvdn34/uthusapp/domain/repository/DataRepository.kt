package com.thanhnvdn34.uthusapp.domain.repository

import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.data.model.Data

interface DataRepository {

    suspend fun getBeers(page: Int): List<Beer>

    suspend fun getBeersFromDB(): List<Beer>

    suspend fun saveBeersToDB(beers: List<Beer>)

    suspend fun saveBeerToDB(beers: Beer)

    suspend fun updateBeer(id: Int, description: String)

    suspend fun deleteBeer(id: Int)

    suspend fun clearALl()

}