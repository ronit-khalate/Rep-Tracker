package com.ronit.reptracker.routine.presentation.Routine.event

import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import com.ronit.reptracker.routine.domain.model.RoutineDto

sealed class SingleRoutineScreenEvent {

    data class SaveRoutine(val routineDto: RoutineDto): SingleRoutineScreenEvent()

    data class OnRoutineNameEntered(val name:String): SingleRoutineScreenEvent()

    object OnAddExercisedBtnClicked: SingleRoutineScreenEvent()

    object OnBackNavigate: SingleRoutineScreenEvent()

    data class GetRoutine(val routineId:Int):SingleRoutineScreenEvent()

    data class CreateNewRoutine(val routineDto: RoutineDto):SingleRoutineScreenEvent()

    data class AddExerciseToRoutine @OptIn(ExperimentalMaterialApi::class) constructor(
        val exercise:ExerciseDto,
        val routineId:Int,
        val hideBottomSheet:(()->Unit)?
    ):SingleRoutineScreenEvent()
}