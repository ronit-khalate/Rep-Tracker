package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineEntity
import com.ronit.reptracker.routine.domain.model.RoutineDto
import javax.inject.Inject


class CreateNewRoutineUseCase @Inject constructor(
        private val db:RepCounterDatabase
) {

    suspend operator fun invoke(routineDto: RoutineDto){

        db.routineDao().upsertRoutine(routineDto.toRoutineEntity())
    }
}