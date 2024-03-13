package com.ronit.reptracker.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ronit.reptracker.core.utility.Constants
import com.ronit.reptracker.core.utility.Constants.EXERCISE_TABLE_NAME
import com.ronit.reptracker.routine.data.local_datasource.model.ExerciseEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ExerciseDAO {


    @Query("SELECT * FROM $EXERCISE_TABLE_NAME")
    fun getAllExercises(): Flow<List<ExerciseEntity>>

    @Upsert
    suspend fun upsertExercise(exerciseEntity: ExerciseEntity)

    @Query("SELECT * FROM $EXERCISE_TABLE_NAME WHERE exerciseId = :id")
    suspend fun getExerciseById(id:Int):ExerciseEntity
}