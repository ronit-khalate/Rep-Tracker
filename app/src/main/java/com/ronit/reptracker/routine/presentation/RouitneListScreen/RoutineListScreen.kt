package com.ronit.reptracker.routine.presentation.RouitneListScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll

import androidx.compose.ui.tooling.preview.Preview

import com.ronit.reptracker.core.component.TopBar
import com.ronit.reptracker.routine.presentation.component.RoutineListRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoutineListScreen() {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())


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
                        onIconActionClick = {},
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



            items(count = 30){

                RoutineListRow()
            }
        }
    }
}
@Preview(name = "Routine List", showBackground = true)
@Composable
private fun Preview() {

    RoutineListScreen()
}