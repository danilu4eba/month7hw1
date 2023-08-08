package com.example.month7hw1.data.mappers

import com.example.month7hw1.data.db.models.WayEntity


fun List<WayEntity>.mapToWayEntity()= this.map{
    WayEntity(
        id = it.id,
        name = it.name,
        color = it.color
    )
}