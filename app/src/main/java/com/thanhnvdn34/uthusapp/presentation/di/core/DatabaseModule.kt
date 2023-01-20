package com.thanhnvdn34.uthusapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.thanhnvdn34.uthusapp.data.db.DataDao
import com.thanhnvdn34.uthusapp.data.db.UthusDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context): UthusDatabase {
        return Room.databaseBuilder(context, UthusDatabase::class.java, "uthusclient")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(uthusDatabase: UthusDatabase): DataDao {
        return uthusDatabase.dataDao()
    }
}