package com.example.month7hw1.domain.useCases

import com.example.month7hw1.domain.mappers.mapToWayEntity
import com.example.month7hw1.domain.models.WayEntity
import com.example.month7hw1.domain.repositories.WayRepository
import javax.inject.Inject

class GetWayUseCase @Inject constructor(private val repository: WayRepository){
    suspend fun getWay()=  repository.getWays()
    }
