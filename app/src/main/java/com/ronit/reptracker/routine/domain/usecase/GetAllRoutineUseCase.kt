package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineDto
import com.ronit.reptracker.routine.domain.model.RoutineDto
import javax.inject.Inject

class GetAllRoutineUseCase @Inject constructor(
        val db:RepCounterDatabase
) {

    suspend operator fun invoke():List<RoutineDto>{

        return db.routineDao().getAllRoutine()
            .map {
                it.toRoutineDto()
            }
    }
}