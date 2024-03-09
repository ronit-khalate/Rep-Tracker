package com.ronit.reptracker.routine.presentation.RouitneListScreen.state

import com.ronit.reptracker.routine.domain.model.RoutineDto

data class RoutineListScreenState(

        val routineList:List<RoutineDto> = emptyList()
)

