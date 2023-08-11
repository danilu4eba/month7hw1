package com.example.month7hw1.data.repositories

import com.example.month7hw1.data.base.BaseRepository
import com.example.month7hw1.data.db.database.WayDao
import com.example.month7hw1.data.db.models.WayEntity
import com.example.month7hw1.data.mappers.mapToWayEntity
import com.example.month7hw1.domain.repositories.WayRepository
import com.example.month7hw1.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WayRepositoryImpl @Inject constructor(private val wayDao: WayDao) : WayRepository,
    BaseRepository() {

    override suspend fun deleteWay(way: WayEntity): Flow<Resource<Unit>> = makeRequest {
        wayDao.deleteWay(way)
    }


    override suspend fun updateWay(way: WayEntity): Flow<Resource<Unit>> = makeRequest {
        wayDao.updateWay(way)
    }

    override suspend fun createWay(way: WayEntity): Flow<Resource<Unit>> = makeRequest {
        wayDao.createWay(way)
    }

    override suspend fun getWays(): Flow<Resource<List<WayEntity>>> = makeRequest {
        wayDao.getWays().mapToWayEntity()
    }
}
