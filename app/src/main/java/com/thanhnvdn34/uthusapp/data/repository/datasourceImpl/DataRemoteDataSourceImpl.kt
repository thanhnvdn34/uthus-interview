package com.thanhnvdn34.uthusapp.data.repository.datasourceImpl

import com.thanhnvdn34.uthusapp.data.api.UthusService
import com.thanhnvdn34.uthusapp.data.model.Data
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataRemoteDataSource
import retrofit2.Response

class DataRemoteDataSourceImpl(
    private val uthusService: UthusService
) : DataRemoteDataSource {
    override suspend fun getData(page: Int): Response<Data> = uthusService.getData(page)
}