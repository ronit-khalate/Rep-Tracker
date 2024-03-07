package com.ronit.reptracker.routine.domain.usecase

import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.routine.data.repository.RoutineRepositoryImpl
import com.ronit.reptracker.routine.di.RoutineRepositoryImplQualifier

import com.ronit.reptracker.routine.domain.repository.RoutineRepository
import javax.inject.Inject

class AddRoutineUseCase @Inject constructor(
        @RoutineRepositoryImplQualifier
        private val routineRepository: RoutineRepository
) {

    suspend operator fun invoke(routineEntity: RoutineEntity){
        routineRepository.upsertRoutine(routineEntity)
    }
}