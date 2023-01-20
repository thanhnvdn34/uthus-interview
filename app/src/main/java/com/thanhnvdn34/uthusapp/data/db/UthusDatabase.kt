package com.thanhnvdn34.uthusapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thanhnvdn34.uthusapp.data.model.Beer

@Database(entities = [Beer::class], version = 2, exportSchema = false)
abstract class UthusDatabase: RoomDatabase() {

    abstract fun dataDao(): DataDao
}