package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineExerciseCrossRefDto
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineExerciseCrossRefEntity
import com.ronit.reptracker.routine.domain.model.RoutineExerciseCrossRefDto
import javax.inject.Inject

class AddExerciseToRoutineUseCase @Inject constructor(
        private val db:RepCounterDatabase
) {

    suspend operator fun invoke(entity:RoutineExerciseCrossRefDto){

        return db.RoutineExerciseCrossRefDao().addExerciseToRoutine(entity.toRoutineExerciseCrossRefEntity())
    }
}