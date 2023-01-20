package com.thanhnvdn34.uthusapp.data.api

import com.thanhnvdn34.uthusapp.data.model.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UthusService {

    @GET("api/api-testing/sample-data")
    suspend fun getData(@Query("page") page: Int, @Query("limit") limit: Int = 20) : Response<Data>
}