package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.toRoutineWithExerciseDto
import com.ronit.reptracker.routine.domain.model.RoutineWithExercisesDto
import javax.inject.Inject

class GetAllRoutineWithExercisesUsecase @Inject constructor(
        private val db:RepCounterDatabase
) {

    suspend operator fun invoke():List<RoutineWithExercisesDto>{

        return db.routineDao().getRoutineWithExercises().map {
            it.toRoutineWithExerciseDto()
        }

    }
}