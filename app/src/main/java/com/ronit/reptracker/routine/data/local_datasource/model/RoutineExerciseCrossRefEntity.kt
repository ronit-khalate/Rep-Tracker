package com.ronit.reptracker.routine.data.local_datasource.model

import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ronit.reptracker.core.utility.Constants
import com.ronit.reptracker.core.utility.Constants.ROUTINE_WITH_EXERCISES_CROSS_REF_TABLE_NAME


@Entity(primaryKeys = ["routineId","exerciseId"], tableName = ROUTINE_WITH_EXERCISES_CROSS_REF_TABLE_NAME)
data class RoutineExerciseCrossRefEntity(
        val routineId:Int,
        val exerciseId:Int
)
