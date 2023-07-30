package com.example.month7hw1.domain.repositories

import com.example.month7hw1.data.db.models.Way
import com.example.month7hw1.domain.models.WayEntity
import com.example.month7hw1.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface WayRepository {
    suspend fun deleteWay(way: Way) : Flow<Resource<Unit>>

    suspend fun updateWay(way: Way): Flow<Resource<Unit>>

    suspend fun createWay(way: Way): Flow<Resource<Unit>>

    suspend fun getWays(): Flow<Resource<List<WayEntity>>>
}