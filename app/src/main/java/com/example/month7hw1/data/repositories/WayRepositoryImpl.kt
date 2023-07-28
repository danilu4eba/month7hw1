package com.example.month7hw1.data.repositories

import com.example.month7hw1.data.db.database.WayDao
import com.example.month7hw1.data.db.models.Way
import com.example.month7hw1.domain.repositories.WayRepository

class WayRepositoryImpl(private val wayDao: WayDao) : WayRepository {

    override suspend fun deleteWay(way: Way) = wayDao.deleteWay(way)

    override suspend fun updateWay(way: Way) = wayDao.updateWay(way)

    override suspend fun createWay(way: Way) = wayDao.createWay(way)

    override suspend fun getWays(): List<Way> = wayDao.getWays()
}