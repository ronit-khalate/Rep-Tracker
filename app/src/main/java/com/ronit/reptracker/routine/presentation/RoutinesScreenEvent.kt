package com.ronit.reptracker.routine.presentation

import com.ronit.reptracker.routine.domain.model.RoutineDto
import com.ronit.reptracker.routine.domain.model.RoutineExerciseCrossRefDto

sealed class RoutinesScreenEvent {

    sealed class RoutineScreenEvent:RoutinesScreenEvent(){

        data class SaveRoutine(val routine: RoutineDto):RoutineScreenEvent()

        data class GetRoutine(val id:Int,val onGotten:(RoutineDto)->Unit):RoutineScreenEvent()

        object AddExercise:RoutineScreenEvent()
        data class OnExerciseClicked(val routineExerciseCrossRefDto: RoutineExerciseCrossRefDto):RoutineScreenEvent()

    }

    sealed class RoutineListScreenEvent:RoutinesScreenEvent(){

        data class OnRoutineClicked(val routine:RoutineDto):RoutineListScreenEvent()


    }
}