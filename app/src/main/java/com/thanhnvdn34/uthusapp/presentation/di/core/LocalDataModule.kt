package com.thanhnvdn34.uthusapp.presentation.di.core

import com.thanhnvdn34.uthusapp.data.db.DataDao
import com.thanhnvdn34.uthusapp.data.repository.datasource.DataLocalDataSource
import com.thanhnvdn34.uthusapp.data.repository.datasourceImpl.DataLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesDataLocalDataSource(dataDao: DataDao): DataLocalDataSource {
        return DataLocalDataSourceImpl(dataDao)
    }
}