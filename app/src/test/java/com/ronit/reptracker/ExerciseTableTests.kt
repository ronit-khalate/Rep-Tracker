package com.ronit.reptracker

import com.ronit.reptracker.core.database.RepCounterDatabase
import com.ronit.reptracker.routine.data.local_datasource.model.ExerciseEntity
import org.junit.Test
import javax.inject.Inject


class ExerciseTableTests {

    @Inject
    lateinit var db:RepCounterDatabase
    @Test
    fun `should insert a exercise`(){

        val exercise = ExerciseEntity(exerciseName = "demo")

        db.exerciseDao().upsertExercise(exercise)


    }
}