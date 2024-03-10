package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineDto
import com.ronit.reptracker.routine.domain.model.RoutineDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllRoutineUseCase @Inject constructor(
        val db:RepCounterDatabase
) {

    suspend operator fun invoke():Flow<List<RoutineDto>>{

        return db.routineDao().getAllRoutine().map {
            it.map {
                it.toRoutineDto()
            }
        }

    }
}