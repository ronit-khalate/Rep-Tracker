package com.ronit.reptracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ronit.reptracker.core.presentation.BottomBar
import com.ronit.reptracker.core.presentation.Screens
import com.ronit.reptracker.exercise.presentation.ExerciseScreen
import com.ronit.reptracker.routine.presentation.RouitneListScreen.RoutineListScreen
import com.ronit.reptracker.routine.presentation.Routine.SingleRoutineScreen
import com.ronit.reptracker.routine.presentation.RoutineViewModel
import com.ronit.reptracker.ui.theme.RepTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val routineViewModel:RoutineViewModel by viewModels<RoutineViewModel>()
        setContent {
            RepTrackerTheme {


                val navController= rememberNavController()
                Scaffold(
                        bottomBar ={
                            BottomBar(navController = navController)
                        }
                ) {

                    NavHost(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxSize(),
                            navController = navController,
                            startDestination = Screens.RoutineSubNav.route
                    ){

                        navigation(startDestination = Screens.Routine.route,route = Screens.RoutineSubNav.route){

                            composable(route= Screens.Routine.route){

                                RoutineListScreen(viewModel = routineViewModel,navController=navController)
                            }

                            composable(route=Screens.SingleRoutine.route){navBackStackEntry->

                                val argumentVal = navBackStackEntry.arguments?.getString(Screens.SingleRoutine.argument)
                                val id=argumentVal?.toIntOrNull()
                                SingleRoutineScreen(
                                        navController=navController,
                                        routineId = id
                                )
                            }
                        }

                        composable(route = Screens.Exercise.route){

                            ExerciseScreen( navController =navController )
                        }

                       

                    }
                }
            }
        }
    }
}
