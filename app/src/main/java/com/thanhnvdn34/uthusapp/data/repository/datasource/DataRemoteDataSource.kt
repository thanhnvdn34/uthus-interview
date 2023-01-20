package com.thanhnvdn34.uthusapp.data.repository.datasource

import com.thanhnvdn34.uthusapp.data.model.Data
import retrofit2.Response

interface DataRemoteDataSource {
    suspend fun getData(page: Int): Response<Data>
}