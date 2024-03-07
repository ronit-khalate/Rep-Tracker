package com.ronit.reptracker.routine.data.local_datasource.model

import com.ronit.reptracker.routine.domain.model.RoutineDto


fun RoutineEntity.toRoutineDto():RoutineDto{

    return RoutineDto(
            routineName=this.routineName
    )
}

fun RoutineDto.toRoutineEntity():RoutineEntity{

    return RoutineEntity(
            routineName=this.routineName
    )
}