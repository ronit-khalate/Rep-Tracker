package com.ronit.reptracker.exercise.domain.usescases

import com.ronit.reptracker.exercise.di.ExerciseRepositoryImplQulifier
import com.ronit.reptracker.exercise.domain.repository.ExerciseRepository
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import javax.inject.Inject

class AddExerciseUseCase @Inject constructor(
        @ExerciseRepositoryImplQulifier
        private val exerciseRepository: ExerciseRepository
) {

        suspend operator fun invoke(exercise:ExerciseDto){
                exerciseRepository.addExerciseToDb(exercise)
        }
}