package com.example.month7hw1.domain.repositories


import com.example.month7hw1.domain.models.WayEntity
import com.example.month7hw1.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface WayRepository {
    suspend fun deleteWay(way: com.example.month7hw1.data.db.models.WayEntity) : Flow<Resource<Unit>>

    suspend fun updateWay(way: com.example.month7hw1.data.db.models.WayEntity): Flow<Resource<Unit>>

    suspend fun createWay(way: com.example.month7hw1.data.db.models.WayEntity): Flow<Resource<Unit>>

    suspend fun getWays(): Flow<Resource<List<WayEntity>>>
}