package com.ronit.reptracker.routine.data.repository

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineDto
import com.ronit.reptracker.routine.domain.model.RoutineDto
import com.ronit.reptracker.routine.domain.repository.RoutineRepository
import javax.inject.Inject

class RoutineRepositoryImpl @Inject constructor(
        private val db:RepCounterDatabase
):RoutineRepository {
    override suspend fun getAllRoutines(): List<RoutineDto> {

      return emptyList()
    }

    override suspend fun upsertRoutine(routineEntity: RoutineEntity) {

        db.routineDao().upsertRoutine(routineEntity)
    }
}