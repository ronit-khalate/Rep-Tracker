package com.ronit.reptracker.routine.data.local_datasource.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.core.utility.Constants.ROUTINE_TABLE_NAME
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineWithExercises
import kotlinx.coroutines.flow.Flow


@Dao
interface RoutineDAO {

    @Query("SELECT * From $ROUTINE_TABLE_NAME")
    fun getAllRoutine(): Flow<List<RoutineEntity>>

    @Query("SELECT * FROM $ROUTINE_TABLE_NAME WHERE routineId==:id LIMIT 1")
    suspend fun getRoutine(id:Int):RoutineEntity

    @Upsert
    suspend fun upsertRoutine(routineEntity: RoutineEntity)

    @Transaction
    @Query("SELECT * FROM $ROUTINE_TABLE_NAME")
    suspend fun getRoutineWithExercises():List<RoutineWithExercises>
}