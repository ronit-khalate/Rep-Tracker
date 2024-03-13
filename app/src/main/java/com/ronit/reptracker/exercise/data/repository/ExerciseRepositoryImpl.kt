package com.ronit.reptracker.exercise.data.repository

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.exercise.di.ExerciseRepositoryImplQulifier
import com.ronit.reptracker.exercise.domain.repository.ExerciseRepository
import com.ronit.reptracker.routine.data.local_datasource.model.toExerciseEntity
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject  constructor(
        private val db:RepCounterDatabase
): ExerciseRepository {
    override suspend fun addExerciseToDb(exerciseDto: ExerciseDto) {

        db.exerciseDao().upsertExercise(exerciseDto.toExerciseEntity())
    }
}