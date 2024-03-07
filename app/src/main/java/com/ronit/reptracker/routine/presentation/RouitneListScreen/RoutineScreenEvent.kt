package com.ronit.reptracker.routine.presentation.RouitneListScreen

import com.ronit.reptracker.routine.domain.model.RoutineDto

sealed class RoutineScreenEvent {
    object onAddRoutienBtnClikced: RoutineScreenEvent()

    data class onRoutineClicked(val routineDto: RoutineDto): RoutineScreenEvent()

    object onEditBtnClicked: RoutineScreenEvent()
}