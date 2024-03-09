package com.ronit.reptracker.routine.data.local_datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ronit.reptracker.core.utility.Constants.ROUTINE_TABLE_NAME


@Entity(tableName = ROUTINE_TABLE_NAME)
data class RoutineEntity(
        @PrimaryKey(autoGenerate = true)
        val routineId:Int,
        val routineName:String
)