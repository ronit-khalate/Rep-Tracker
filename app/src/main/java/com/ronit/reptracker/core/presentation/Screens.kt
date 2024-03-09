package com.ronit.reptracker.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
        val route:String,
        val argument:String?=null,
        val name:String,
        val icon:ImageVector?,
        val arguments:List<NamedNavArgument> = emptyList()

){

    companion object{

        val screens:List<Screens> = listOf(
                Routine,
                Log,
                Statistics
        )
    }

    object Log:Screens(
            route = "log",
            name = "Log",
            icon = Icons.Filled.AccountCircle,
    )

    object Routine:Screens(
            route = "routine",
            name = "Routine",
            icon = Icons.Filled.AccountCircle,
    )
    object Statistics:Screens(
            route = "statistics",
            name = "Statistics",
            icon = Icons.Filled.AccountCircle,

    )

    object SingleRoutine:Screens(
            route = "routine/{routineId}",
            argument = "routineId",
            name = "Routine",
            icon = null,
            arguments = listOf(
                    navArgument("routineId"){
                        type= NavType.StringType
                        nullable=true
                    }
            )
    ){

        fun createRoute(routineId:Int?):String{

            return "routine/${routineId.toString()}"
        }
    }

    object RoutineSubNav:Screens(
            route = "routineSubNav",
            name = "",
            icon = null
    )

}