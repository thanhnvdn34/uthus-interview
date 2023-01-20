package com.thanhnvdn34.uthusapp.data.repository

import android.util.Log
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.data.model.Data
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataLocalDataSource
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataRemoteDataSource
import com.thanhnvdn34.uthusapp.domain.repository.DataRepository

class DataRepositoryImpl(
    private val dataLocalDataSource: DataLocalDataSource,
    private val dataRemoteDataSource: DataRemoteDataSource
) : DataRepository {
    override suspend fun getBeers(page: Int): List<Beer> {
        lateinit var data: List<Beer>

        try {
            val response = dataRemoteDataSource.getData(page)
            val body = response.body()
            if (body != null) {
                data = body.data
            }
        } catch (ex: Exception) {
            Log.i("DataRepository", ex.message.toString())
        }
        return data
    }

    override suspend fun getBeersFromDB(): List<Beer> {
        lateinit var beerList: List<Beer>

        try {
            beerList = dataLocalDataSource.getBeersFromDB()
        } catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }

        return beerList
    }

    override suspend fun saveBeersToDB(beers: List<Beer>) {
        try {
            dataLocalDataSource.saveBeersToDB(beers)
        } catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
    }

    override suspend fun saveBeerToDB(beer: Beer) {
        try {
            dataLocalDataSource.saveBeerToDB(beer)
        } catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
    }

    override suspend fun updateBeer(id: Int, description: String) {
        try {
            dataLocalDataSource.updateBeer(id, description)
        } catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
    }

    override suspend fun deleteBeer(id: Int) {
        try {
            dataLocalDataSource.deleteBeer(id)
        } catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
    }

    override suspend fun clearALl() {
        try {
            dataLocalDataSource.clearALl()
        } catch (ex: Throwable) {
            Log.i("TAG", ex.message.toString())
        }

    }
}