package com.ronit.reptracker.exercise.domain.repository

import com.ronit.reptracker.routine.domain.model.ExerciseDto

interface ExerciseRepository {

    suspend fun addExerciseToDb(exerciseDto: ExerciseDto)
}