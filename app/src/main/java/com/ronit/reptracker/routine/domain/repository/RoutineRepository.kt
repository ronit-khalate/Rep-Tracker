package com.ronit.reptracker.routine.domain.repository

import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.routine.domain.model.RoutineDto

interface RoutineRepository {

   suspend fun getAllRoutines():List<RoutineDto>

   suspend fun upsertRoutine(routineEntity: RoutineEntity)
}