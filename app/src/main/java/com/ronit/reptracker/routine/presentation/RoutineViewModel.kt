package com.ronit.reptracker.routine.presentation

import androidx.lifecycle.ViewModel
import com.ronit.reptracker.routine.domain.usecase.AddRoutineUseCase
import com.ronit.reptracker.routine.presentation.RouitneListScreen.RoutineScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoutineViewModel @Inject constructor(
        private val addRoutineUseCase: AddRoutineUseCase
):ViewModel() {



    fun onEvent(event: RoutineScreenEvent){

        when(event){
            is RoutineScreenEvent.onAddRoutienBtnClikced -> TODO()
            is RoutineScreenEvent.onEditBtnClicked -> TODO()
            is RoutineScreenEvent.onRoutineClicked -> TODO()
        }
    }

}