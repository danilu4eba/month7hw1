package com.example.month7hw1.data.db.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.month7hw1.data.db.models.WayEntity

@Dao
interface WayDao {

    @Query("SELECT * FROM Way")
     fun getWays(): List<WayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createWay(way: WayEntity)

    @Update
    suspend fun updateWay(way: WayEntity)

    @Delete
    suspend fun deleteWay(way: WayEntity)
}