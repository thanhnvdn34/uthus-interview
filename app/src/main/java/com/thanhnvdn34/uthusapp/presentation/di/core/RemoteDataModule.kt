package com.thanhnvdn34.uthusapp.presentation.di.core

import com.thanhnvdn34.uthusapp.data.api.UthusService
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataRemoteDataSource
import com.thanhnvdn34.uthusapp.data.repository.datasourceImpl.DataRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule {
    
    @Singleton
    @Provides
    fun providesDataRemoteDataSource(uthusService: UthusService): DataRemoteDataSource {
        return DataRemoteDataSourceImpl(uthusService)
    }
}