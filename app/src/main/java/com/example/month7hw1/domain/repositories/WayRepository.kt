package com.example.month7hw1.domain.repositories

import com.example.month7hw1.data.db.models.Way

interface WayRepository {
    suspend fun deleteWay(way: Way)

    suspend fun updateWay(way: Way)

    suspend fun createWay(way: Way)

    suspend fun getWays(): List<Way>
}