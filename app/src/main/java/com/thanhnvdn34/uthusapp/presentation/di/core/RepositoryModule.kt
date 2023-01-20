package com.thanhnvdn34.uthusapp.presentation.di.core

import com.thanhnvdn34.uthusapp.data.repository.DataRepositoryImpl
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataLocalDataSource
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataRemoteDataSource
import com.thanhnvdn34.uthusapp.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(
        dataLocalDataSource: DataLocalDataSource,
        dataRemoteDataSource: DataRemoteDataSource
    ): DataRepository {
        return DataRepositoryImpl(dataLocalDataSource, dataRemoteDataSource)
    }
}