package com.thanhnvdn34.uthusapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thanhnvdn34.uthusapp.data.model.Beer

@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBeer(beers: List<Beer>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBeer(beer: Beer)

    @Query("select * from beers")
    suspend fun getBeers(): List<Beer>

    @Query("UPDATE beers SET description=:description WHERE id=:id ")
    suspend fun updateBeer(id: Int, description: String)

    @Query("delete from beers WHERE id=:id ")
    suspend fun deleteBeer(id: Int)

    @Query("delete from beers ")
    suspend fun deleteAll()
}