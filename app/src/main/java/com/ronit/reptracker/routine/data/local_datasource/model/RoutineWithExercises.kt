package com.ronit.reptracker.routine.data.local_datasource.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class RoutineWithExercises(

        @Embedded
        val routineEntity: RoutineEntity,

        @Relation(
                parentColumn = "routineId",
                entityColumn = "exerciseId",
                associateBy = Junction(RoutineExerciseCrossRefEntity::class)
        )
        val exercises:List<ExerciseEntity>
)
