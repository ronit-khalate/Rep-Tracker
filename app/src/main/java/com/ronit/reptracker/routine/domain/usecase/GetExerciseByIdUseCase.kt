package com.ronit.reptracker.routine.domain.usecase

import android.util.Log
import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.toExerciseDto
import com.ronit.reptracker.routine.domain.model.ExerciseDto
import javax.inject.Inject

class GetExerciseByIdUseCase @Inject constructor(
        private val db:RepCounterDatabase
) {

    suspend operator fun invoke(exerciseId:Int):ExerciseDto{

        /*
        *! don't do like this db.exerciseDao().getExerciseById(exerciseId).toExerciseDto()
        *
        *  it will give nullPointerExeception
        *  because it takes some time to get exercise from the db so the result will
        * be null until the query returns the exercise and because we are  calling mapper
        * function on it so will are calling mapper function on null
        * because the result null cause query is not completed yet
        * */

        Log.d("getexe","${exerciseId}")
        val id=exerciseId
        val exerciseEntity= db.exerciseDao().getExerciseById(exerciseId)

        Log.d("getexe","${exerciseEntity.toString()}")

        return exerciseEntity.toExerciseDto()
    }
}