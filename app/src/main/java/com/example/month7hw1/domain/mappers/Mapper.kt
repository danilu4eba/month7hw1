package com.example.month7hw1.domain.mappers

import com.example.month7hw1.data.db.models.Way
import com.example.month7hw1.domain.models.WayEntity

fun List<Way>.mapToWayEntity()= this.map{
    WayEntity(
        id = it.id,
        name = it.name,
        color = it.color
    )
}