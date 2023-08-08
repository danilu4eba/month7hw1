package com.example.month7hw1.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Way")
data class WayEntity(
    @PrimaryKey(true)
    val id: Int,
    val name: String,
    val color: Int
)
