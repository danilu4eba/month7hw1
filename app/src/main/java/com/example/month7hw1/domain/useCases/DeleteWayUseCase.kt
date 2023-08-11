package com.example.month7hw1.domain.useCases


import com.example.month7hw1.data.db.models.WayEntity
import com.example.month7hw1.domain.repositories.WayRepository
import javax.inject.Inject

class DeleteWayUseCase @Inject constructor(private val wayRepository: WayRepository) {
    suspend fun deleteWay(wayEntity: WayEntity) = wayRepository.deleteWay(wayEntity)

}