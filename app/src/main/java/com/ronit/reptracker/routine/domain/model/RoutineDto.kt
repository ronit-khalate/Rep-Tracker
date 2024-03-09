package com.ronit.reptracker.routine.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class RoutineDto(
    val routineId:Int,
    val routineName:String="Unnamed Routine"

)