package com.ronit.reptracker.routine.data.local_datasource.model

import com.ronit.reptracker.routine.domain.model.ExerciseDto
import com.ronit.reptracker.routine.domain.model.RoutineDto
import com.ronit.reptracker.routine.domain.model.RoutineExerciseCrossRefDto
import com.ronit.reptracker.routine.domain.model.RoutineWithExercisesDto


// Routine
fun RoutineEntity.toRoutineDto():RoutineDto{

    return RoutineDto(
            routineId=this.routineId,
            routineName=this.routineName
    )
}

fun RoutineDto.toRoutineEntity():RoutineEntity{

    return RoutineEntity(
            routineId=this.routineId,
            routineName=this.routineName
    )
}

// Exercise
fun ExerciseEntity.toExerciseDto():ExerciseDto{

    return ExerciseDto(
            exerciseId=this.exerciseId,
            name = this.exerciseName
    )
}

fun ExerciseDto.toExerciseEntity():ExerciseEntity{

    return ExerciseEntity(
            exerciseId=this.exerciseId,
            exerciseName = this.name

    )
}

// Routine Exercise Cross Ref

fun RoutineExerciseCrossRefEntity.toRoutineExerciseCrossRefDto():RoutineExerciseCrossRefDto{

    return RoutineExerciseCrossRefDto(
            routineId=this.routineId,
            exerciseId=this.exerciseId
    )
}

fun RoutineExerciseCrossRefDto.toRoutineExerciseCrossRefEntity():RoutineExerciseCrossRefEntity{

    return  RoutineExerciseCrossRefEntity(
            routineId=this.routineId,
            exerciseId=this.exerciseId
    )
}

// RoutineWithExercises

fun RoutineWithExercises.toRoutineWithExerciseDto():RoutineWithExercisesDto{

    return RoutineWithExercisesDto(
            routineId = this.routineEntity.routineId,
            routineName = this.routineEntity.routineName,
            exercises=this.exercises.map { it.toExerciseDto() }
    )
}
