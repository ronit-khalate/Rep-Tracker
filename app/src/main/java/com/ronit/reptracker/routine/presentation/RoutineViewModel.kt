package com.ronit.reptracker.routine.presentation.Routine

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ronit.reptracker.routine.domain.usecase.AddRoutineUseCase
import com.ronit.reptracker.routine.presentation.Routine.state.RoutineScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(
        val addRoutineUseCase: AddRoutineUseCase
):ViewModel() {

        val state = mutableStateOf(RoutineScreenState(exerciseList = emptyList()))

}