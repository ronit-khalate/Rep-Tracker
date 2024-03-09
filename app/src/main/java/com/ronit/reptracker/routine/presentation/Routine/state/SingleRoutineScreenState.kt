package com.ronit.reptracker.routine.presentation.Routine.state

import com.ronit.reptracker.routine.domain.model.ExerciseDto
import com.ronit.reptracker.routine.domain.model.RoutineDto

data class SingleRoutineScreenState(
        val routine:RoutineDto=RoutineDto(0),
        val exerciseList:List<ExerciseDto> = emptyList()
)
