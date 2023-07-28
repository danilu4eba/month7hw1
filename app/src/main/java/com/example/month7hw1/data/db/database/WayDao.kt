package com.example.month7hw1.data.db.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.month7hw1.data.db.models.Way

@Dao
interface WayDao {

    @Query("SELECT * FROM Way")
    suspend fun getWays(): List<Way>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWay(way: Way)

    @Update
    suspend fun updateWay(way: Way)

    @Delete
    suspend fun deleteWay(way: Way)
}