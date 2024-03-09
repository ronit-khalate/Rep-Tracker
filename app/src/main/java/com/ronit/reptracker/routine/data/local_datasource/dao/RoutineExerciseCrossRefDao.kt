package com.ronit.reptracker.routine.data.local_datasource.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineExerciseCrossRefEntity


@Dao
interface RoutineExerciseCrossRefDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseToRoutine(entity:RoutineExerciseCrossRefEntity)
}