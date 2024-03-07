package com.ronit.reptracker.routine.data.local_datasource.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ronit.reptracker.core.utility.Constants

@Entity(tableName = Constants.EXERCISE_TABLE_NAME)
class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    @ColumnInfo(name = "name")
    val name:String
)