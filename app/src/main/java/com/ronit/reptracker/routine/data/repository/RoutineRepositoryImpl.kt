package com.ronit.reptracker.routine.data.repository

import com.ronit.reptracker.core.database.Database
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineDto
import com.ronit.reptracker.routine.domain.model.RoutineDto
import com.ronit.reptracker.routine.domain.repository.RoutineRepository
import javax.inject.Inject

class RoutineRepositoryImpl @Inject constructor(
        private val db:Database
):RoutineRepository {
    override suspend fun getAllRoutines(): List<RoutineDto> {

        val routineList:List<RoutineDto> = db.routineDao().getAllRoutine()
            .map {
                it.toRoutineDto()
            }

        return routineList
    }

    override suspend fun upsertRoutine(routineEntity: RoutineEntity) {

        db.routineDao().upsertRoutine(routineEntity)
    }
}