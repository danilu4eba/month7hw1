package com.example.month7hw1.domain.useCases

import com.example.month7hw1.data.db.models.Way
import com.example.month7hw1.domain.repositories.WayRepository
import javax.inject.Inject

class UpdateUseCase @Inject constructor(private val wayRepository:WayRepository) {

    suspend fun updateWay(way: Way) = wayRepository.updateWay(way)
}