package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.ExerciseEntity
import com.ronit.reptracker.routine.data.local_datasource.model.toExerciseDto
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllExerciseUseCase @Inject constructor(
        private val db:RepCounterDatabase
) {

    operator fun invoke(): Flow<List<ExerciseEntity>> {
        return  db.exerciseDao().getAllExercises()

    }
}