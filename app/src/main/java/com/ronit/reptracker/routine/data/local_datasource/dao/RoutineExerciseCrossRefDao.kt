package com.ronit.reptracker.routine.data.local_datasource.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ronit.reptracker.routine.domain.model.ExerciseDto


@Dao
interface RoutineExerciseCrossRefDTO {


    suspend fun addExerciseToRoutine(exerciseId:Int)
}