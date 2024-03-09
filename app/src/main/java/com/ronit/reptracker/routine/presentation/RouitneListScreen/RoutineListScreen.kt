package com.ronit.reptracker.routine.presentation.RouitneListScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ronit.reptracker.core.presentation.Screens

import com.ronit.reptracker.core.presentation.TopBar
import com.ronit.reptracker.routine.presentation.RoutineViewModel
import com.ronit.reptracker.routine.presentation.component.RoutineListRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoutineListScreen(
    viewModel: RoutineViewModel,
    navController: NavController
) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val showBottomSheet by remember {
        mutableStateOf(false)
    }


    Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopBar(
                        textAction = "Edit",
                        title = "Routines",
                        iconAction = Icons.Filled.Add,
                        onTextActionClick = { /*TODO*/ },
                        onIconActionClick = {
                            TODO()
                            navController.navigate(Screens.SingleRoutine.createRoute(null))
                        },
                        onBackNavigate = {},
                        scrollBehavior = scrollBehavior
                )
            }
    ) {


        LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
        ) {



            items(
                    items = viewModel.allRoutines.value
            ){

                RoutineListRow(it.routineName+it.routineId){
                    navController.navigate(Screens.SingleRoutine.createRoute(it.routineId))
                }
            }
        }
    }
}
//@Preview(name = "Routine List", showBackground = true)
//@Composable
//private fun Preview() {
//
//    RoutineListScreen(rememberNavController())
//}