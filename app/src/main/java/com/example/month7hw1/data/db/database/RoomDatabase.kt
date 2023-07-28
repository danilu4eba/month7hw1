package com.example.month7hw1.data.db.database

import androidx.room.Database
import com.example.month7hw1.data.db.models.Way

@Database(entities = [Way::class], version = 1)
abstract class RoomDatabase {
}