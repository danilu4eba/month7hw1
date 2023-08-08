package com.example.month7hw1.data.repositories

import com.example.month7hw1.data.db.database.WayDao
import com.example.month7hw1.data.db.models.WayEntity
import com.example.month7hw1.data.mappers.mapToWayEntity

import com.example.month7hw1.domain.repositories.WayRepository
import com.example.month7hw1.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WayRepositoryImpl @Inject constructor(private val wayDao: WayDao) : WayRepository {

    override suspend fun deleteWay(way: WayEntity): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = wayDao.getWays()
            emit(Resource.Success(wayDao.deleteWay(way)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override suspend fun updateWay(way: WayEntity): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = wayDao.getWays()
            emit(Resource.Success(wayDao.updateWay(way)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override suspend fun createWay(way: WayEntity): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = wayDao.getWays()
            emit(Resource.Success(wayDao.createWay(way)))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage as String))
        }
    }

    override suspend fun getWays(): Flow<Resource<List<WayEntity>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = wayDao.getWays()
                emit(Resource.Success(data.mapToWayEntity()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage as String))
            }
        }
    }
}
