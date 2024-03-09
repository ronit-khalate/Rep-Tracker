package com.ronit.reptracker.routine.data.local_datasource.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ronit.reptracker.core.utility.Constants
import com.ronit.reptracker.routine.data.local_datasource.model.ExerciseEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ExerciseDAO {


    @Query("SELECT * FROM ${Constants.EXERCISE_TABLE_NAME}")
    fun getAllExercises(): Flow<List<ExerciseEntity>>

    @Upsert
    suspend fun upsertExercise(exerciseEntity: ExerciseEntity)
}