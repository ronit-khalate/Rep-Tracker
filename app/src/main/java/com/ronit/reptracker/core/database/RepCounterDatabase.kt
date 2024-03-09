package com.ronit.reptracker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ronit.reptracker.routine.data.local_datasource.dao.ExerciseDAO
import com.ronit.reptracker.routine.data.local_datasource.dao.RoutineDAO
import com.ronit.reptracker.routine.data.local_datasource.dao.RoutineExerciseCrossRefDao
import com.ronit.reptracker.routine.data.local_datasource.model.ExerciseEntity
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineExerciseCrossRefEntity

@Database(entities = [RoutineEntity::class,ExerciseEntity::class,RoutineExerciseCrossRefEntity::class], version = 1)
abstract class RepCounterDatabase:RoomDatabase() {
    abstract fun routineDao(): RoutineDAO
    abstract fun exerciseDao():ExerciseDAO
    abstract fun RoutineExerciseCrossRefDao():RoutineExerciseCrossRefDao
}