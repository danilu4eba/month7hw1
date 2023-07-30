package com.example.month7hw1.domain.useCases

import com.example.month7hw1.data.db.models.Way
import com.example.month7hw1.domain.repositories.WayRepository
import javax.inject.Inject

class CreateWayUseCase @Inject constructor(private val wayRepository: WayRepository) {
    suspend fun createWay(way: Way) = wayRepository.createWay(way)
}