package com.ronit.reptracker.routine.presentation.Routine

sealed class RoutineScreenEvent {

    object SaveRoutine:RoutineScreenEvent()

    data class OnRoutineNameEntered(val name:String):RoutineScreenEvent()

    object OnAddExercisedClicked:RoutineScreenEvent()

    object OnBackNavigate:RoutineScreenEvent()
}