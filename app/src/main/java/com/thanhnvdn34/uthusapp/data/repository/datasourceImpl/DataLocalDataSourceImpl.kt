package com.thanhnvdn34.uthusapp.data.repository.datasourceImpl

import com.thanhnvdn34.uthusapp.data.db.DataDao
import com.thanhnvdn34.uthusapp.data.model.Beer
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataLocalDataSource

class DataLocalDataSourceImpl(
    private val dataDao: DataDao
) : DataLocalDataSource {
    override suspend fun getBeersFromDB(): List<Beer> {
        return dataDao.getBeers()
    }

    override suspend fun saveBeersToDB(beers: List<Beer>) {
        dataDao.saveBeer(beers)
    }

    override suspend fun saveBeerToDB(item: Beer) {
        dataDao.saveBeer(item)
    }

    override suspend fun updateBeer(id: Int, description: String) {
        dataDao.updateBeer(id, description)
    }

    override suspend fun deleteBeer(id: Int) {
        dataDao.deleteBeer(id)
    }

    override suspend fun clearALl() {
        dataDao.deleteAll()
    }
}