package com.ronit.reptracker.routine.data.local_datasource.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.core.utility.Constants.ROUTINE_TABLE_NAME


@Dao
interface RoutineDAO {

    @Query("SELECT * From $ROUTINE_TABLE_NAME")
    suspend fun getAllRoutine():List<RoutineEntity>

    @Upsert
    suspend fun upsertRoutine(routineEntity: RoutineEntity):Unit
}