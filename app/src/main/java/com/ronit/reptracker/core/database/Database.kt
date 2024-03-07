package com.ronit.reptracker.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ronit.reptracker.routine.data.local_datasource.dao.RoutineDAO
import com.ronit.reptracker.routine.data.local_datasource.model.RoutineEntity

@Database(entities = [RoutineEntity::class], version = 1)
abstract class Database:RoomDatabase() {
    abstract fun routineDao(): RoutineDAO
}