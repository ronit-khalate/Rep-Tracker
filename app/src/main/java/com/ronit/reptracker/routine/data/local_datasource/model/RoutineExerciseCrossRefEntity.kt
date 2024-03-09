package com.ronit.reptracker.routine.data.local_datasource.model

import androidx.room.Entity


@Entity(primaryKeys = ["routineId","exerciseId"])
data class RoutineExerciseCrossRef(

        val routineId:Int,
        val exerciseId:Int
)
