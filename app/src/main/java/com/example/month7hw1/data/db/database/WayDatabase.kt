package com.example.month7hw1.data.db.database

import androidx.room.Database
import com.example.month7hw1.data.db.models.WayEntity

@Database(entities = [WayEntity::class], version = 1)
abstract class WayDatabase {
    abstract fun getWayDao():WayDao
}