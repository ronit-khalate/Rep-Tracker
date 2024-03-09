package com.ronit.reptracker.routine.domain.model

data class RoutineWithExercisesDto(
        val routineId:Int,
        val routineName:String,
        val exercises:List<ExerciseDto>
)